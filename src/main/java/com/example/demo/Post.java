package com.example.demo;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String AuthorID;
    private String message;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(String AuthorID) {
        this.AuthorID = AuthorID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	

	public void setTimeStamp(LocalDateTime now, Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setTimestamp(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
}