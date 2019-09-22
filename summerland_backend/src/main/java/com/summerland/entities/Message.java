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
@Table(name = "messages")
public class Message {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String message;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="OWNER")
	private Owner owner;

	public Message() {
		super();
	}

	public Message(String message, Customer customer, Owner owner) {
		super();
		this.message = message;
		this.customer = customer;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
}
