package org.distributedproficiency.dojo.dto;

import org.distributedproficiency.dojo.domain.KataContent;

public class KataSaveRequest {
    private KataContent newContent;

    public KataSaveRequest() {
        super();
    }

    public KataSaveRequest(KataContent c) {
        super();
        this.newContent = c;
    }

    public KataContent getNewContent() {
        return newContent;
    }

    public void setNewContent(KataContent newContent) {
        this.newContent = newContent;
    }
}
