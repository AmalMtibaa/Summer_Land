package com.summerland.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "owners")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String email;
	private String password;
	private String name;
	private String lastname;
	private String telephone;
	private String address;

	@Lob
	private Byte[] image;
	
	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Message> messages;
	
	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@JsonIgnore
	private Collection<House> houses;

	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Alert> alerts;
	
	
	public Owner() {
		super();
	}

	public Owner( String email, String password, String name, String lastname, String telephone,
			String address, Byte[] image) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.telephone = telephone;
		this.address = address;
		this.image = image;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	public Collection<House> getHouses() {
		return houses;
	}

	public void setHouses(Collection<House> houses) {
		this.houses = houses;
	}

	public Collection<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(Collection<Alert> alerts) {
		this.alerts = alerts;
	}
	
	

}
