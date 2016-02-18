package org.distributedproficiency.dojo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class KataAttempt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User reviewer;

    @OneToOne
    private User attemptor;

    @OneToOne
    private Kata kata;

    @Temporal(value=TemporalType.TIMESTAMP)
    private Date attemptedTimeStamp;
    
    private KataAttemptStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public User getAttemptor() {
        return attemptor;
    }

    public void setAttemptor(User attemptor) {
        this.attemptor = attemptor;
    }

    public Kata getKata() {
        return kata;
    }

    public void setKata(Kata kata) {
        this.kata = kata;
    }

    public Date getAttemptedTimeStamp() {
        return attemptedTimeStamp;
    }

    public void setAttemptedTimeStamp(Date attemptedTimeStamp) {
        this.attemptedTimeStamp = attemptedTimeStamp;
    }

    public KataAttemptStatus getStatus() {
        return status;
    }

    public void setStatus(KataAttemptStatus status) {
        this.status = status;
    }
}
