package org.distributedproficiency.dojo.dto;

import org.distributedproficiency.dojo.auth.DojoUserRole;

import java.util.Date;

public class UserOverview {

    private Long userId;
    private String username;
    private Date createdDateTime;
    private DojoUserRole userRole;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public DojoUserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(DojoUserRole userRole) {
        this.userRole = userRole;
    }
}
