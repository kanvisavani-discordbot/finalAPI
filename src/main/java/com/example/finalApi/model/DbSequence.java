package com.example.finalApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequence {
    @Id
    private String  id;
    private int seq;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}