package com.summerland.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "alert")
public class Alert {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String message;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="ADMIN")
	private Admin admin;
	
	@ManyToOne
	@JoinColumn(name="OWNER")
	private Owner owner;

	public Alert() {
		super();
	}

	public Alert(String message, String type, Admin admin, Owner owner) {
		super();
		this.message = message;
		this.type = type;
		this.admin = admin;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
	
	
}
