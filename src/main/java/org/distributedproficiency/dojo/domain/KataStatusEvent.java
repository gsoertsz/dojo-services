package org.distributedproficiency.dojo.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class KataStatusEvent {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long kataId;

    @Temporal(value=TemporalType.TIMESTAMP)
    private Date statusChangeDateTime;
    private KataStatus fromStatus;
    private KataStatus toStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKataId() {
        return kataId;
    }

    public void setKataId(Long kataId) {
        this.kataId = kataId;
    }

    public Date getStatusChangeDateTime() {
        return statusChangeDateTime;
    }

    public void setStatusChangeDateTime(Date statusChangeDateTime) {
        this.statusChangeDateTime = statusChangeDateTime;
    }

    public KataStatus getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(KataStatus fromStatus) {
        this.fromStatus = fromStatus;
    }

    public KataStatus getToStatus() {
        return toStatus;
    }

    public void setToStatus(KataStatus toStatus) {
        this.toStatus = toStatus;
    }
}
