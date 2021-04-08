package com.gorest.automation;

import com.gorest.automation.objects.User;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static com.gorest.automation.utils.RandomDataGenerator.generate;

public class UsersTest extends BaseTest {
    private String name = generate().randomString();
    private String email = name + "@lala.com";
    private String gender = generate().gender();
    private String status = generate().status();
    private User user;

    @BeforeEach
    public void beforeEach() {
        user = requests.post().user(name, gender, email, status);
    }

    @AfterEach
    public void afterEach() {
        Assert.assertEquals("User with id: '" + user.getId() + "' wasn't deleted",
                204, requests.delete().user(user.getId()));
    }

    @Test
    public void verifyUserCreation() {
        User searchedUser = requests.get().userById(user.getId());

        Assert.assertEquals("User name is: '" + searchedUser.getName() + "' but should be: '" + name + "'",
                name, searchedUser.getName());

        Assert.assertEquals("User email is: '" + searchedUser.getEmail() + "' but should be: '" + email + "'",
                email, searchedUser.getEmail());

        Assert.assertEquals("User gender is: '" + searchedUser.getGender() + "' but should be: '" + gender + "'",
                gender, searchedUser.getGender());

        Assert.assertEquals("User status is: '" + searchedUser.getStatus() + "' but should be: '" + status + "'",
                status, searchedUser.getStatus());
    }

    @Test
    public void verifyUserNameUpdate() {
        String newName = generate().randomString();
        User updatedUser = requests.patch().userName(user.getId(), newName);

        Assert.assertEquals("User name is: '" + updatedUser.getName() + "' but should be: '" + newName + "'",
                newName, updatedUser.getName());

    }

    @Test
    public void verifyUserUpdate() {
        String newName = generate().randomString();
        String newEmail = newName + "@lala.com";
        String newGender = generate().gender();
        String newStatus = generate().status();
        User updatedUser = requests.put().user(user.getId(), newName, newGender, newEmail, newStatus);

        Assert.assertEquals("User name is: '" + updatedUser.getName() + "' but should be: '" + newName + "'",
                newName, updatedUser.getName());

        Assert.assertEquals("User gender is: '" + updatedUser.getGender() + "' but should be: '" + newGender + "'",
                newGender, updatedUser.getGender());

        Assert.assertEquals("User email is: '" + updatedUser.getEmail() + "' but should be: '" + newEmail + "'",
                newEmail, updatedUser.getEmail());

        Assert.assertEquals("User status is: '" + updatedUser.getStatus() + "' but should be: '" + newStatus + "'",
                newStatus, updatedUser.getStatus());

    }
}
