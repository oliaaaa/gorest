package com.gorest.automation.objects;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private int id;
    private String gender;
    private String updatedAt;
    private String name;
    private String createdAt;
    private String email;
    private String status;

    public User(JSONObject userResponse) {
        setId(userResponse);
        setGender(userResponse);
        setUpdatedAt(userResponse);
        setName(userResponse);
        setCreatedAt(userResponse);
        setEmail(userResponse);
        setStatus(userResponse);
    }
    public int getId() { return id;}

    public String getGender() { return gender;}

    public String getUpdatedAt() { return updatedAt;}

    public String getName() { return name;}

    public String createdAt() { return createdAt;}

    public String getEmail() { return email;}

    public String getStatus() { return status;}

    private void setId(JSONObject user) {
        try {
            this.id = user.getInt("id");
        } catch (JSONException e) {
            this.id = 0;
        }
    }

    private void setGender(JSONObject user) {
        try {
            this.gender = user.getString("gender");
        } catch (JSONException e) {
            this.gender = "";
        }
    }

    private void setUpdatedAt(JSONObject user) {
        try {
            this.updatedAt = user.getString("updated_at");
        } catch (JSONException e) {
            this.updatedAt = "";
        }
    }

    private void setName(JSONObject user) {
        try {
            this.name = user.getString("name");
        } catch (JSONException e) {
            this.name = "";
        }
    }

    private void setCreatedAt(JSONObject user) {
        try {
            this.createdAt = user.getString("created_at");
        } catch (JSONException e) {
            this.createdAt = "";
        }
    }

    private void setEmail(JSONObject user) {
        try {
            this.email = user.getString("email");
        } catch (JSONException e) {
            this.email = "";
        }
    }

    private void setStatus(JSONObject user) {
        try {
            this.status = user.getString("status");
        } catch (JSONException e) {
            this.status = "";
        }
    }
    }
