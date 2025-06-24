package com.example.model;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class UserStore {
    private final Vertx vertx;
    private JsonArray users = new JsonArray();

    public UserStore(Vertx vertx) {
        this.vertx = vertx;
    }

    public void loadJsonFile(String path) {
        vertx.fileSystem().readFile(path, result -> {
            if (result.succeeded()) {
                users = result.result().toJsonArray();
            } else {
                System.err.println("❌ Failed to load users.");
            }
        });
    }

    public JsonArray getUsers() {
        return users;
    }

    public void addUser(JsonObject user) {
        users.add(user);
    }

    public boolean updateUser(int id, JsonObject updated) {
        for (int i = 0; i < users.size(); i++) {
            JsonObject user = users.getJsonObject(i);
            if (user.getInteger("id") == id) {
                users.set(i, updated);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.getJsonObject(i).getInteger("id") == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }
}

