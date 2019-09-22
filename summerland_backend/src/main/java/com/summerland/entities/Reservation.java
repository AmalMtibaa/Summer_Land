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

import java.util.Date;


@Entity
@Table(name = "reservations")
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String confirmation;
	private Date date_debut;
	private Date date_fin;

	@ManyToOne
	@JoinColumn(name="CUSTOMER")
	private Customer customer;
	

	@ManyToOne
	@JoinColumn(name="HOUSE")

	private House house;

	public Reservation() {
	}

	public Reservation(String confirmation, Date date_debut, Date date_fin, Customer customer, House house) {
		this.confirmation = confirmation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.customer = customer;
		this.house = house;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
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


	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id=" + id +
				", confirmation='" + confirmation + '\'' +
				", date_debut=" + date_debut +
				", date_fin=" + date_fin +
				", customer=" + customer +
				", house=" + house +
				'}';
	}
}
