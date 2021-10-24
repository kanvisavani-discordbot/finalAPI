package com.example.finalApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Plan")
public class Plan {
	
@Id
private long id;
private String name;
private String priority;

public Plan() {
	super();
}

public Plan(String name, String priority) {
	super();
	this.name=name;
	this.priority=priority;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}
}
