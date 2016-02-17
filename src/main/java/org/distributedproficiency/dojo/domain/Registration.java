package org.distributedproficiency.dojo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String registrationKey;
	
	@OneToOne
	private Student student;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date initiatedDateTime;
	
	private RegistrationStatus status;
	
	public Registration() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegistrationStatus getStatus() {
		return status;
	}

	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}

	public String getRegistrationKey() {
		return registrationKey;
	}

	public void setRegistrationKey(String registrationKey) {
		this.registrationKey = registrationKey;
	}

	public Date getInitiatedDateTime() {
		return initiatedDateTime;
	}

	public void setInitiatedDateTime(Date initiatedDateTime) {
		this.initiatedDateTime = initiatedDateTime;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
