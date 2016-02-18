package org.distributedproficiency.dojo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KataTag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String tagName;

    public KataTag() {
        super();
    }

    public KataTag(String n) {
        super();
        this.tagName = n;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
