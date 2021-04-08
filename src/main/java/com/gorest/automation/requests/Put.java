package com.gorest.automation.requests;

import com.gorest.automation.objects.User;
import org.json.JSONException;
import org.json.JSONObject;

import static com.gorest.automation.requests.Requests.putRequest;

public class Put {
    public User user(int userId, String name, String gender, String email, String status) {
            JSONObject response = putRequest("https://gorest.co.in/public-api/users/" + userId,
                    "{\"name\":\"" + name + "\", \"gender\":\"" + gender +
                            "\", \"email\":\"" + email + "\", \"status\":\"" + status + "\"}");
            JSONObject user;
            try {
                user = response.getJSONObject("data");
            } catch (JSONException e) {
                user = new JSONObject();
                System.out.println("ERROR in putUser. Response is --- " + response);
            }
            return new User(user);

    }
}
