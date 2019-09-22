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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String login;
	private String email;
	private String password;
	private String name;
	private String lastname;
	private String telephone;
	private String address;

	@Lob
	private Byte[] image;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Reservation> reservations;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Review> reviews;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Reaction> reactions;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Message> messages;

	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Recommandation> recommandations;
	
	
	public Customer() {
		super();
	}
	
	

	public Customer(String login, String email, String password, String lastname, String name, String telephone,
			String address, Byte[] image) {
		super();
		this.login = login;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}

	public Collection<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(Collection<Reaction> reactions) {
		this.reactions = reactions;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}



	public Byte[] getImage() {
		return image;
	}



	public void setImage(Byte[] image) {
		this.image = image;
	}



	public Collection<Recommandation> getRecommandations() {
		return recommandations;
	}



	public void setRecommandations(Collection<Recommandation> recommandations) {
		this.recommandations = recommandations;
	}
	
	
	
	
	
}
