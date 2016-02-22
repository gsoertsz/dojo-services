package org.distributedproficiency.dojo.dto;

public class UserCreatedResponse {
    private Long createdUserId;
    private String createdUsername;
    private Long createdDateTime;

    public UserCreatedResponse(Long createdUserId, String createdUsername, Long createdDateTime) {
        super();
        this.createdUserId = createdUserId;
        this.createdUsername = createdUsername;
        this.createdDateTime = createdDateTime;
    }

    public UserCreatedResponse() {
        super();
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getCreatedUsername() {
        return createdUsername;
    }

    public void setCreatedUsername(String createdUsername) {
        this.createdUsername = createdUsername;
    }

    public Long getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
