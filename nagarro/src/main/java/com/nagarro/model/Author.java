package com.nagarro.model;

import java.util.List;

public class Author {
	private int authId;
	private String authName;

	List<Book> book;

	public Author(int authId, String authName, List<Book> book) {

		this.authId = authId;
		this.authName = authName;
	}

	public Author(int authId, String authName) {
		super();
		this.authId = authId;
		this.authName = authName;
	}
	public Author(String authName) {
		super();
		this.authName = authName;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	@Override
	public String toString() {
		return "Author [authId=" + authId + ", authName=" + authName + ", book=" + book + "]";
	}

}
