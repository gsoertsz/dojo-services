package org.distributedproficiency.dojo.dto;

public class KataCreatedResponse {

    private Long createdKataId;
    private Long createdDateTimeMillis;

    public KataCreatedResponse(Long createdKataId, Long createdDateTimeMillis) {
        super();
        this.createdKataId = createdKataId;
        this.createdDateTimeMillis = createdDateTimeMillis;
    }

    public KataCreatedResponse() {
        super();
    }

    public Long getCreatedKataId() {
        return createdKataId;
    }

    public void setCreatedKataId(Long createdKataId) {
        this.createdKataId = createdKataId;
    }

    public Long getCreatedDateTimeMillis() {
        return createdDateTimeMillis;
    }

    public void setCreatedDateTimeMillis(Long createdDateTimeMillis) {
        this.createdDateTimeMillis = createdDateTimeMillis;
    }
}
