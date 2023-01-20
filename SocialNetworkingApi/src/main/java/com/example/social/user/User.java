package com.example.social.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.social.location.Location;
@Entity
public class User {

    @Id
	private String id;
	private String firstlname;
	private String lastname;
	private String email;
	
	@ManyToOne
	private Location location;
	
	public User() {
		
	}

	public User(String id, String firstlname, String lastname, String email, Location location) {
		super();
		this.id = id;
		this.firstlname = firstlname;
		this.lastname = lastname;
		this.email = email;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstlname() {
		return firstlname;
	}

	public void setFirstlname(String firstlname) {
		this.firstlname = firstlname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstlname=" + firstlname + ", lastname=" + lastname + ", email=" + email
				+ ", location=" + location + "]";
	}
	
	
	
}
