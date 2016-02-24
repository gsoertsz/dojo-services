/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.distributedproficiency.dojo.domain;

import org.distributedproficiency.dojo.auth.DojoUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -49075115110864095L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;


    @Temporal(value=TemporalType.TIMESTAMP)
    private Date createdDateTime;

    @OneToMany
    private Collection<KataAttempt> completedKatas;

    @OneToMany
    private Collection<KataAttempt> inProgressKatas;

    private DojoUserRole userRole;

    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private boolean accountNonLocked;

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

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(userRole.toString());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }


    public DojoUserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(DojoUserRole userRole) {
        this.userRole = userRole;
    }

    public static User create(String username, String password, DojoUserRole role) {
        User u = new User(username, password);
        u.setUserRole(role);

        return u;
    }
}
