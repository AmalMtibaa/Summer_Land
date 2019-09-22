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
@Table(name = "places")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Place {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String name;
	private String description;
	
	@Lob
    private Collection<byte[]> images;
    
    @OneToMany(mappedBy="place",fetch=FetchType.LAZY)
    @JsonIgnore
	private Collection<Recommandation> recommandations;
    
    @OneToMany(mappedBy="place",fetch=FetchType.LAZY)
    @JsonIgnore
   	private Collection<House> houses;

    
    
	public Place() {
		super();
	}
	
	

	public Place(String name, Collection<byte[]> images) {
		super();
		this.name = name;
		this.images = images;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<byte[]> getImages() {
		return images;
	}

	public void setImages(Collection<byte[]> images) {
		this.images = images;
	}

	public Collection<Recommandation> getRecommandations() {
		return recommandations;
	}

	public void setRecommandations(Collection<Recommandation> recommandations) {
		this.recommandations = recommandations;
	}

	public Collection<House> getHouses() {
		return houses;
	}

	public void setHouses(Collection<House> houses) {
		this.houses = houses;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
    
	
    
}
