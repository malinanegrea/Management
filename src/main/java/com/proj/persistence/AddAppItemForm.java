package com.proj.persistence;

import javax.validation.constraints.NotNull;

import com.proj.persistence.entity.Application;
import com.proj.persistence.entity.User;

public class AddAppItemForm {

	@NotNull
	private int userId;

	@NotNull
	private int appId;

	private Iterable<Application> apps;

	private User user;

	public AddAppItemForm() {
	}

	public AddAppItemForm(Iterable<Application> apps, User user) {
		this.apps = apps;
		this.user = user;
		for(Application app:apps) {
			System.out.println(app.getName());
		}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public Iterable<Application> getApps() {
		return apps;
	}

	public void setApps(Iterable<Application> apps) {
		this.apps = apps;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
