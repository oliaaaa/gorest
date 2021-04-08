package com.gorest.automation.utils;

import com.gorest.automation.utils.enums.Gender;
import com.gorest.automation.utils.enums.Status;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
    public static RandomDataGenerator generate() {
        return new RandomDataGenerator();
    }

    public String randomString() {
        return UUID.randomUUID().toString().substring(25);
    }

    public String gender() {
        List<Gender> genders = List.of(
                Gender.MALE, Gender.FEMALE);

        return genders.get(new Random().nextInt(genders.size())).getValue();
    }

    public String status() {
        List<Status> statuses = List.of(
                Status.ACTIVE, Status.INACTIVE);

        return statuses.get(new Random().nextInt(statuses.size())).getValue();
    }
}
