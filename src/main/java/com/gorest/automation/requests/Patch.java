package com.gorest.automation.requests;

import com.gorest.automation.objects.User;
import org.json.JSONException;
import org.json.JSONObject;

import static com.gorest.automation.requests.Requests.patchRequest;

public class Patch {
    public User userName(int userId, String newName) {
        JSONObject response = patchRequest("https://gorest.co.in/public-api/users/" + userId,
                "{\"name\":\"" + newName + "\"}");
        JSONObject user;
        try {
            user = response.getJSONObject("data");
        } catch (JSONException e) {
            user = new JSONObject();
            System.out.println("ERROR in patchUserName. Response is --- " + response);
        }
        return new User(user);
    }
}
