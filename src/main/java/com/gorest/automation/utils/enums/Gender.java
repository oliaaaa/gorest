package com.gorest.automation.utils.enums;

public enum Gender {
        MALE("Male"),
        FEMALE("Female");

        private String gender;

        Gender(String gender) {
            this.gender = gender;
        }

        public String getValue() {
            return gender;
        }
}
