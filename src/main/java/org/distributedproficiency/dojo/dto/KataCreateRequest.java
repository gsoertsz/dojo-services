package org.distributedproficiency.dojo.dto;

public class KataCreateRequest {
    private String authorId;

    public KataCreateRequest(String authorId) {
        super();
        this.authorId = authorId;
    }

    public KataCreateRequest() {
        super();
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
