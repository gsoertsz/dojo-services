package org.distributedproficiency.dojo.dto;

public class UserCreateRequest {
    private String username;
    private String password;

    public UserCreateRequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
