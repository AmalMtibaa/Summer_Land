package com.summerland.entities;

public class Filter {

	private String city;
	private String catagory;
	private int numb_bedrooms;
		private int numb_bathrooms;
	private double price_min;
	private double price_max;
	private double size_min;
	private double size_max;
	
	
	
	/*public Filter(String cityc, String catagoryc, int numb_bedroomsc, int numb_bathroomsc, double price_minc,
			double price_maxc, double size_minc, double size_maxc) {
		super();
		if(cityc.equals("All Cities"))
			this.city = "";
		else this.city = cityc;
		if(catagoryc.equals("All Categories"))
			this.catagory = "";
		else this.catagory = catagoryc;
		this.numb_bedrooms = numb_bedroomsc;
		this.numb_bathrooms = numb_bathroomsc;
		this.price_min = price_minc;
		this.price_max = price_maxc;
		this.size_min = size_minc;
		this.size_max = size_maxc;
	}*/
	
	
	
	public String getCity() {
		return city;
	}
	public Filter() {
		super();
	}
	public Filter(String city, String catagory, int numb_bedrooms, int numb_bathrooms, double price_min,
			double price_max, double size_min, double size_max) {
		super();
		this.city = city;
		this.catagory = catagory;
		this.numb_bedrooms = numb_bedrooms;
		this.numb_bathrooms = numb_bathrooms;
		this.price_min = price_min;
		this.price_max = price_max;
		this.size_min = size_min;
		this.size_max = size_max;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public int getNumb_bedrooms() {
		return numb_bedrooms;
	}
	public void setNumb_bedrooms(int numb_bedrooms) {
		this.numb_bedrooms = numb_bedrooms;
	}
	public int getNumb_bathrooms() {
		return numb_bathrooms;
	}
	public void setNumb_bathrooms(int numb_bathrooms) {
		this.numb_bathrooms = numb_bathrooms;
	}
	public double getPrice_min() {
		return price_min;
	}
	public void setPrice_min(double price_min) {
		this.price_min = price_min;
	}
	public double getPrice_max() {
		return price_max;
	}
	public void setPrice_max(double price_max) {
		this.price_max = price_max;
	}
	public double getSize_min() {
		return size_min;
	}
	public void setSize_min(double size_min) {
		this.size_min = size_min;
	}
	public double getSize_max() {
		return size_max;
	}
	public void setSize_max(double size_max) {
		this.size_max = size_max;
	}
	@Override
	public String toString() {
		return "Filter [city=" + city + ", catagory=" + catagory + ", numb_bedrooms=" + numb_bedrooms
				+ ", numb_bathrooms=" + numb_bathrooms + ", price_min=" + price_min + ", price_max=" + price_max
				+ ", size_min=" + size_min + ", size_max=" + size_max + "]";
	}
	
	
	
	
	
}
