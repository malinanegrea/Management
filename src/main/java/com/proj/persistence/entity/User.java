package com.proj.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@Component
public class User{

	/**
	 * 
	 */

	@Id
	@Column(name = "identifier")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identifier;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "appuser", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "appId") })
	private Set<Application> applications = new HashSet<Application>();

	public User() {
	}
	public User(int identifier, String name, String username, String password, Set<Application> applications) {
		setIdentifier(identifier);
		setName(name);
		setUsername(username);
		setPassword(password);
		setApplications(applications);
	}

	public User(String name, String username, String password) {
		setName(name);
		setUsername(username);
		setPassword(password);
	}

	

	
	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int id) {
		this.identifier = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*
	 * public List<Application> getApplicatins() { return applications; }
	 */

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "Users [identifier=" + identifier + ", name=" + name + ", username=" + username + ", password= "
				+ password + "]";
	}
	@Override
	public int hashCode() {
		int h = 1;
		if (identifier != 0) {
			h *= identifier;
		}
		if (name != null) {
			h *= name.hashCode();
		}
		if (username != null) {
			h *= username.hashCode();
		}
		if (password != null) {
			h *= password.hashCode();
		}
		return h;
	}

}
