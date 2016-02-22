package org.distributedproficiency.dojo.domain;

public class KataContent {
    private String allContent;

    private KataContent(String allContent) {
        super();
        this.allContent = allContent;
    }

    private KataContent() {
        super();
    }

    public String getAllContent() {
        return allContent;
    }

    public void setAllContent(String allContent) {
        this.allContent = allContent;
    }
}
