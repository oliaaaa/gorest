package com.gorest.automation;

import com.gorest.automation.requests.ApiRequests;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private final static RequestSpecification requestSpecification = new RequestSpecBuilder().build()
            .header("Authorization", "Bearer 5a10f5d977f031381eb679381aaeecf42ef1fb43e7ded2303da375b1fb79b0ba")
            .relaxedHTTPSValidation();
    public static ApiRequests requests = new ApiRequests();

    @BeforeAll
    public static void before() {
        System.out.println("beforeAll");
        RestAssured.requestSpecification = requestSpecification;
    }
}
