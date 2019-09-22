package com.summerland.entities;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "houses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class House {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String header_name;
	private String address;
	private String description;
	private double surface;
	private boolean seaview;
	private int age;
	private double price;
	private String typeOfPaiement;
	private int rooms_number;
	private int garage_number;
	private int bathrooms_number;
	private String type;
	private String[] details;

	@Transient
	private MultipartFile image;
	private String pathimage;

	@Transient
	private MultipartFile[] images;
	private String[] pathimages;

	public void addPathImages(String path_image,int i){
		this.pathimages[i]=path_image;
	}

	@ManyToOne
	@JoinColumn(name="PLACE")
	private Place place;
	

	@ManyToOne
	@JoinColumn(name="OWNER")
	private Owner owner;
	
	@OneToMany(mappedBy="house",fetch=FetchType.LAZY)
	@JsonIgnore
	@Cascade(CascadeType.ALL)
	private Collection<Review> reviews;
	
	@OneToMany(mappedBy="house",fetch=FetchType.LAZY)
	@JsonIgnore
	@Cascade(CascadeType.ALL)
	private Collection<Reaction> reactions;
	
	@OneToMany(mappedBy="house",fetch=FetchType.LAZY)
	@JsonIgnore
	private Collection<Reservation> reservations;

	public House() {
		super();
	}

	public String getHeader_name() {
		return header_name;
	}

	public void setHeader_name(String header_name) {
		this.header_name = header_name;
	}

	public int getGarage_number() {
		return garage_number;
	}

	public void setGarage_number(int garage_number) {
		this.garage_number = garage_number;
	}

	public int getBathrooms_number() {
		return bathrooms_number;
	}

	public String getTypeOfPaiement() {
		return typeOfPaiement;
	}

	public void setTypeOfPaiement(String typeOfPaiement) {
		this.typeOfPaiement = typeOfPaiement;
	}

	public void setBathrooms_number(int bathrooms_number) {
		this.bathrooms_number = bathrooms_number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultipartFile[] getImages() {
		return images;
	}

	public void setImages(MultipartFile[] images) {
		this.images = images;
	}

	public String[] getPathimages() {
		return pathimages;
	}

	public void setPathimages(String[] pathimages) {
		this.pathimages = pathimages;
	}

	public House(String header_name, String address, String description, double surface, boolean seaview, int age, double price, String typeOfPaiement, int rooms_number, int garage_number, int bathrooms_number, String type, Byte[] image, Collection<byte[]> images, Place place, Owner owner, Collection<Review> reviews, Collection<Reaction> reactions) {
		this.header_name = header_name;
		this.address = address;
		this.description = description;
		this.surface = surface;
		this.seaview = seaview;
		this.age = age;
		this.price = price;
		this.typeOfPaiement = typeOfPaiement;
		this.rooms_number = rooms_number;
		this.garage_number = garage_number;
		this.bathrooms_number = bathrooms_number;
		this.type = type;
		this.place = place;
		this.owner = owner;
		this.reviews = reviews;
		this.reactions = reactions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public boolean isSeaview() {
		return seaview;
	}

	public void setSeaview(boolean seaview) {
		this.seaview = seaview;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRooms_number() {
		return rooms_number;
	}

	public void setRooms_number(int rooms_number) {
		this.rooms_number = rooms_number;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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

	public String[] getDetails() {
		return details;
	}

	public void setDetails(String[] details) {
		this.details = details;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getPathimage() {
		return pathimage;
	}

	public void setPathimage(String pathimage) {
		this.pathimage = pathimage;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}


	@Override
	public String toString() {
		return "House{" +
				"id=" + id +
				", header_name='" + header_name + '\'' +
				", address='" + address + '\'' +
				", description='" + description + '\'' +
				", surface=" + surface +
				", seaview=" + seaview +
				", age=" + age +
				", price=" + price +
				", typeOfPaiement='" + typeOfPaiement + '\'' +
				", rooms_number=" + rooms_number +
				", garage_number=" + garage_number +
				", bathrooms_number=" + bathrooms_number +
				", type='" + type + '\'' +
				", details=" + Arrays.toString(details) +
				", image=" + image +
				", pathimage='" + pathimage + '\'' +
				", images=" + Arrays.toString(images) +
				", pathimages=" + Arrays.toString(pathimages) +
				", place=" + place +
				", owner=" + owner +
				", reviews=" + reviews +
				", reactions=" + reactions +
				", reservations=" + reservations +
				'}';
	}
}
