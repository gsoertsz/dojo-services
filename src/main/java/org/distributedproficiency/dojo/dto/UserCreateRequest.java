package org.distributedproficiency.dojo.dto;

public class UserCreateRequest {
    private String username;

    public UserCreateRequest(String username) {
        super();
        this.username = username;
    }

    public UserCreateRequest() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
