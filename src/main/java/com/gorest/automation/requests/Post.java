package com.gorest.automation.requests;

import com.gorest.automation.objects.User;
import org.json.JSONException;
import org.json.JSONObject;
import static com.gorest.automation.requests.Requests.postRequest;

public class Post {
    public User user(String name, String gender, String email, String status) {
        JSONObject response = postRequest("https://gorest.co.in/public-api/users",
                "{\"name\":\"" + name + "\", \"gender\":\"" + gender +
                "\", \"email\":\"" + email + "\", \"status\":\"" + status + "\"}");
        JSONObject user;
        try {
            user = response.getJSONObject("data");
        } catch (JSONException e) {
            user = new JSONObject();
            System.out.println("ERROR in postUser. Response is --- " + response);
        }
            return new User(user);
    }
}
