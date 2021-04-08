package com.gorest.automation.requests;

import com.gorest.automation.objects.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import static com.gorest.automation.requests.Requests.getRequest;
import static com.gorest.automation.requests.Requests.getRequestWithParam;

public class Get {
    public List<User> users() {
        JSONObject response = getRequest("https://gorest.co.in/public-api/users");
        int pages;
        try {
            pages = response.getJSONObject("meta").getJSONObject("pagination").getInt("pages");
        } catch (JSONException e) {
            pages = 1;
            System.out.println("ERROR in users. Response is --- " + response);
        }

        List<User> users = new LinkedList<>();

//        for (int i =0; i <= pages; i++) {
            JSONObject usersResponse = getRequest("https://gorest.co.in/public-api/users?page=" + pages);
            JSONArray usersArray;
            try {
                usersArray = usersResponse.getJSONArray("data");
            } catch (JSONException e) {
                usersArray = new JSONArray();
                System.out.println("ERROR in users. Response is --- " + response);
            }

            for (int j = 0; j < usersArray.length(); j++) {
                JSONObject user = usersArray.getJSONObject(j);
                User userObject = new User(user);
                users.add(userObject);
            }

//        }

        return users;
    }

    public User userById(int id) {
        JSONObject response = getRequestWithParam("https://gorest.co.in/public-api/users", "id", String.valueOf(id));
        JSONArray usersArray;
        try {
            usersArray = response.getJSONArray("data");
        } catch (JSONException e) {
            usersArray = new JSONArray();
            System.out.println("ERROR in getUsers. Response is --- " + response);
        }

        JSONObject user = usersArray.getJSONObject(0);
        return new User(user);
    }
}
