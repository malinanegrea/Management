package com.proj.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "application")
@Component
public class Application{


	@Id
	@Column(name = "identifier")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int identifier;

	@Column(name = "name")
	private String name;

	@Column(name = "technology")
	private String technology;

	@Column(name = "version")
	private int version;

	/*@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	@JsonIgnore
	@JoinTable(name = "appuser", joinColumns = @JoinColumn(name = "appId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private Set<User> userlist = new HashSet<User>();

	public Set<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(Set<User> userlist) {
		this.userlist = userlist;
	}
*/
	public Application() {

	}

	public Application(int identifier, String name, String technology, int version) {
		setIdentifier(identifier);
		setName(name);
		setTechnology(technology);
		setVersion(version);
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

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	/*
	 * public List<User> getUsers() { return users; }
	 * 
	 * public void setUsers(List<User> users) { this.users = users; }
	 */

	@Override
	public String toString() {
		return "Application [identifier=" + identifier + ", name=" + name + ", technology=" + technology + ", version= "
				+ version + "]";
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
		if (technology != null) {
			h *= technology.hashCode();
		}
		if (version != 0) {
			h *= version;
		}
		return h;

	}

}