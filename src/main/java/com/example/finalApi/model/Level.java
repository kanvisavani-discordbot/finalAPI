package com.example.finalApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Level")
public class Level {
	
@Transient	
public static final String SEQUENCE_NAME="level_sequence";
	
@Id
private int id;
private String name;
private String member;
private String priority;

public int getId() {
	return id;
}
public void setId(int id) {
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
public String getMember() {
	return member;
}
public void setMember(String member) {
	this.member = member;
}

}
