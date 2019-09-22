package com.summerland.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "admins")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String login;
	private String email;
	private String password;
	private String name;
	private String lastname;
	private String admin_degree;
	
	@OneToMany(mappedBy="admin",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Admin> admins;
	
	@ManyToOne
	@JoinColumn(name="ADMIN")
	private Admin admin;
	
	@OneToMany(mappedBy="admin",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Alert> alerts;

	
	
	public Admin() {
		super();
	}


	public Admin(String login, String email, String password, String name, String lastname, String admin_degree,
			Collection<Admin> admins) {
		super();
		this.login = login;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.admin_degree = admin_degree;
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


	public String getAdmin_degree() {
		return admin_degree;
	}


	public void setAdmin_degree(String admin_degree) {
		this.admin_degree = admin_degree;
	}


	public Collection<Admin> getAdmins() {
		return admins;
	}


	public void setAdmins(Collection<Admin> admins) {
		this.admins = admins;
	}


	public Collection<Alert> getAlerts() {
		return alerts;
	}


	public void setAlerts(Collection<Alert> alerts) {
		this.alerts = alerts;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	
}
