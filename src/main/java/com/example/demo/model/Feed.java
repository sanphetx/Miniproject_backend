package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feed {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 private String username;
	    private String feedname;
	    private String feedcontent;
	   
	    
    

	public Feed(Long id, String feedname, String feedcontent, String imageUrl) {
			super();
			this.id = id;
			this.feedname = username;
			this.feedname = feedname;
			this.feedcontent = feedcontent;
			
		}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Feed() {
        // Default constructor
    }

    public Feed(String feedname, String feedcontent) {
        this.feedname = feedname;
        this.feedcontent = feedcontent;
    }

    public Long getId() {
        return id;
    }

    public String getFeedname() {
        return feedname;
    }

    public void setFeedname(String feedname) {
        this.feedname = feedname;
    }

    public String getFeedcontent() {
        return feedcontent;
    }

    public void setFeedcontent(String feedcontent) {
        this.feedcontent = feedcontent;
    }
}