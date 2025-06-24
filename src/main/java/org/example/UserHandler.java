package com.example.handler;

import com.example.model.UserStore;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class UserHandler {
    private final UserStore store;

    public UserHandler(Vertx vertx) {
        this.store = new UserStore(vertx);
    }

    public void loadData() {
        store.loadJsonFile("data.json");
    }

    public void handleGetUsers(RoutingContext ctx) {
        ctx.response()
                .putHeader("Content-Type", "application/json")
                .end(store.getUsers().encodePrettily());
    }

    public void handleAddUser(RoutingContext ctx) {
        JsonObject user = ctx.getBodyAsJson();
        if (user == null) {
            ctx.response().setStatusCode(400).end("Invalid JSON");
            return;
        }
        store.addUser(user);
        ctx.response().setStatusCode(201).end("User added.");
    }


    public void handleUpdateUser(RoutingContext ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        JsonObject user = ctx.getBodyAsJson();
        boolean updated = store.updateUser(id, user);
        ctx.response().end(updated ? "User updated." : "User not found.");
    }

    public void handleDeleteUser(RoutingContext ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = store.deleteUser(id);
        ctx.response().end(deleted ? "User deleted." : "User not found.");
    }

    public void handleSlowRequest(RoutingContext ctx) {
        try {
            Thread.sleep(2000); // Simulate a blocking operation
            ctx.response().end("This was a blocking handler");
        } catch (InterruptedException e) {
            ctx.fail(e);
        }
    }
}

