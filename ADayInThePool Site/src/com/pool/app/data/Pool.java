package com.pool.app.data;

import java.io.Serializable;

public class Pool implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;

	public String getName() {
		return name;
	}

	public Pool setName(String name) {
		this.name = name;
		return this;
	}
	
	String description;

	public String getDescription() {
		return description;
	}

	public Pool setDescription(String description) {
		this.description = description;
		return this;
	}
	
	String photo;

	public String getPhoto() {
		return photo;
	}

	public Pool setPhoto(String photo) {
		this.photo = photo;
		return this;
	}
	
	String hiddenPhoto;

	public String getHiddenPhoto() {
		return hiddenPhoto;
	}

	public Pool setHiddenPhoto(String hiddenPhoto) {
		this.hiddenPhoto = hiddenPhoto;
		return this;
	}
}