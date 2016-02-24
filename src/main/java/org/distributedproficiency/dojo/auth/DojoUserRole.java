package org.distributedproficiency.dojo.auth;

public enum DojoUserRole {
    AUTHOR("AUTHOR"),
    USER("USER"),
    STUDENT("STUDENT"),
    ADMIN("ADMIN"),
    SUPERUSER("SUPERUSER");

    private String name;

    private DojoUserRole(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
