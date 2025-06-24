package com.example;

import com.example.handler.UserHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class MainApp extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);

        // Load data and register routes
        UserHandler userHandler = new UserHandler(vertx);
        userHandler.loadData();

        // Middleware
        router.route().handler(BodyHandler.create());

        // Routes
        router.get("/users").handler(userHandler::handleGetUsers);
        router.post("/users").handler(userHandler::handleAddUser);
        router.put("/users/:id").handler(userHandler::handleUpdateUser);
        router.delete("/users/:id").handler(userHandler::handleDeleteUser);
        router.get("/slow").blockingHandler(userHandler::handleSlowRequest);

        // Start server on port 8080
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8080, res -> {
                    if (res.succeeded()) {
                        System.out.println(" Server running at http://localhost:8080/");
                    } else {
                        System.out.println("Failed to launch server: " + res.cause().getMessage());
                    }
                });
    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(new MainApp());
    }
}
