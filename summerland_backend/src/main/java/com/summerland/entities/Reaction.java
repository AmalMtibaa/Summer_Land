package com.summerland.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reactions")
public class Reaction {

	@Id
    @GeneratedValue
	private Long id;
	private String reaction_type;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="HOUSE")
	private House house;

	public Reaction() {
		super();
	}

	public Reaction(String reaction_type, Customer customer, House house) {
		super();
		this.reaction_type = reaction_type;
		this.customer = customer;
		this.house = house;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReaction_type() {
		return reaction_type;
	}

	public void setReaction_type(String reaction_type) {
		this.reaction_type = reaction_type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
	
}
