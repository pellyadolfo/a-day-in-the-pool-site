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
	
	int count;
}
