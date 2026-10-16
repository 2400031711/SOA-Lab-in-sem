
package com.example.userdetailsportal.dto;

public class UserResponse {

    private Long userId;
    private String username;
    private String email;
    private String mobileNumber;
    private Integer age;
    private String city;
    private String state;

    public UserResponse() {
    }

    public UserResponse(Long userId, String username, String email,
                        String mobileNumber, Integer age,
                        String city, String state) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.city = city;
        this.state = state;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
