package com.gorest.automation.requests;

import org.json.JSONException;
import org.json.JSONObject;

import static com.gorest.automation.requests.Requests.deleteRequest;

public class Delete {
    public int user(int userId) {
        JSONObject response = deleteRequest("https://gorest.co.in/public-api/users/" + userId);
        int code;
        try {
            code = response.getInt("code");
        } catch (JSONException e) {
            code = 0;
            System.out.println("ERROR in deleteUser. Response is --- " + response);
        }
        return code;
    }
}
