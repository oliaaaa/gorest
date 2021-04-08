package com.gorest.automation.utils.enums;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }
}
