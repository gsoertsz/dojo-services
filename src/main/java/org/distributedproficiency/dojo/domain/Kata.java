package org.distributedproficiency.dojo.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Kata {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User author;

    @OneToMany
    private Collection<KataTag> tags;

    @Temporal(value=TemporalType.TIMESTAMP)
    private Date createdDateTime;

    @Temporal(value=TemporalType.TIMESTAMP)
    private Date lastUpdatedDateTime;

    private KataStatus status;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Collection<KataTag> getTags() {
        return tags;
    }

    public void setTags(Collection<KataTag> tags) {
        this.tags = tags;
    }

    public KataStatus getStatus() {
        return status;
    }

    public void setStatus(KataStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }


    public Date getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }


}
