package com.example.finalApi.model;

public class AuthenticationRequest {
	
	private String fullname;
    private String password;
    
    public AuthenticationRequest() {
    	
    }

	public String getFullName() {
		return fullname;
	}

	public void setFullName(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
