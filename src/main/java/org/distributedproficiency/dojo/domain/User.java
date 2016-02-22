/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.distributedproficiency.dojo.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class User /*implements UserDetails*/ {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -49075115110864095L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    private Date createdDateTime;

    @OneToMany
    private Collection<KataAttempt> completedKatas;

    @OneToMany
    private Collection<KataAttempt> inProgressKatas;

    public static User create(String username) {
        User u = new User(username);
        return u;
    }

	private String username;

	private String password;
	
	public User() {
		super();
	}

	@SuppressWarnings("unchecked")
	private User(String username) {
		this(username, null);
	}

	private User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<KataAttempt> getCompletedKatas() {
        return completedKatas;
    }

    public void setCompletedKatas(Collection<KataAttempt> completedKatas) {
        this.completedKatas = completedKatas;
    }

    public Collection<KataAttempt> getInProgressKatas() {
        return inProgressKatas;
    }

    public void setInProgressKatas(Collection<KataAttempt> inProgressKatas) {
        this.inProgressKatas = inProgressKatas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
