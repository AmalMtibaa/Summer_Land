package com.summerland.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.summerland.business.*;
import com.summerland.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HouseController {
	
	@Autowired
	private IBusinessHouse houseTreatment;
	@Autowired
	private IBusinessOwner ownerTreatment;
	@Autowired
	private IBusinessCustomer customerTreatment;
	@Autowired
	private IBusinessPlace placeTreatment;
	@Autowired
	private IBusinessReservation reservationTreatment;

	
	@RequestMapping(value = "/gethouses")
	public ArrayList<House> getHouses() {
		return houseTreatment.getHouses();
	}

	@RequestMapping(value = "/getowners")
	public ArrayList<Owner> getOwner() {
		return ownerTreatment.getOwner();
	}
	
	@RequestMapping(value = "/getcustmers")
	public ArrayList<Customer> getCustomer() {
		return customerTreatment.getCustomer();
	}

	@RequestMapping(value = "/getPlaces")
	public ArrayList<Place> getPlaces() {
		return placeTreatment.getPlaces();
	}

	@GetMapping(value = "/getHouseById/{id}")
	public House getHouseById(@PathVariable("id") Long idHouse) {
		return houseTreatment.getHouseById(idHouse);
	}

	@GetMapping(value = "/getOwnerById/{id}")
	public Owner getOwnerById(@PathVariable("id") Long idOwner) {
		return ownerTreatment.findById(idOwner);
	}
	
	@RequestMapping(value = "/savehouse", method = RequestMethod.POST)
    public ArrayList<House> saveHouse(@ModelAttribute House house) {
		Long idOwner=house.getOwner().getId();
		System.out.println("saving house ..");
        houseTreatment.saveHouse(house);
        return houseTreatment.listHousesOfOwner(idOwner);
    }

	@PostMapping(path = "/saveReservation")
	public void saveReservation(@RequestBody Reservation r) {
		System.out.println(r.toString());
		System.out.println("saving Reservation ..");
		reservationTreatment.saveReservation(r);
	}

	@GetMapping(value = "/getConfirmedReservations/{id}")
	public ArrayList<Reservation> getConfirmedReservations(@PathVariable("id") Long idHouse) {
		return reservationTreatment.listHouses_confirmer(idHouse);
	}

	@GetMapping(value = "/getHousesByIdOwner/{id}")
	public ArrayList<House> getHousesByIdOwner(@PathVariable("id") Long idOwner) {
		return houseTreatment.listHousesOfOwner(idOwner);
	}

	@GetMapping(value = "/getReservationsRequests/{id}")
	public ArrayList<Reservation> getReservationsRequests(@PathVariable("id") Long idHouse) {
		return reservationTreatment.listHouses_attendre(idHouse);
	}
/*
	@GetMapping(value = "/acceptReservation/{id}")
	public ArrayList<Reservation> acceptReservation(@PathVariable("id") Long idReservation) {
		reservationTreatment.acceptReservation(idReservation);
		Reservation r=reservationTreatment.getReservation(idReservation);
		return reservationTreatment.listHouses_confirmer(r.getHouse().getId());
	}*/

	@RequestMapping(value = "/acceptReservation/{id}")
	public ArrayList<Reservation> acceptReservation(@PathVariable("id") Long idReservation) {
		System.out.println(idReservation);
		reservationTreatment.acceptReservation(idReservation );
		Reservation r=reservationTreatment.getReservation(idReservation);
		return reservationTreatment.listHouses_confirmer(r.getHouse().getId());
	}

	@GetMapping(value = "/refuseReservation/{id}")
	public void refuseReservation(@PathVariable("id") Long idReservation) {
		reservationTreatment.refuseReservation(idReservation);
	}

	@GetMapping(value = "/customerReservation/{id}")
	public ArrayList<Reservation> getCustomerReservations(@PathVariable("id") Long idCustomer){
		return reservationTreatment.listReservationsOfCustomer(idCustomer);
	}

	//////////////yassss
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public ArrayList<House> filter(@ModelAttribute Filter filter) {
		System.out.println("filtering ..");
		return houseTreatment.filter_houses(filter);
	}

	//////////////yasss
	@RequestMapping(value = "/filtertest")
	public ArrayList<House> filter() {
		Filter filter=new Filter("sousse","villa",2,3,200,2000,2,10);
		System.out.println("#-_-_-_-_-_-_-_-_--__--_-"+filter);
		return houseTreatment.filter_houses(filter);
	}



    @RequestMapping(value = "/getString")
    public void getString() {
		Owner o=new Owner("mtibaa.amall@gmail.com","123","Amal","Mtibaa","93750292","doesn't matter",null);
		ownerTreatment.saveOwner(o);
		House h=new House("Villa house in Marsa","marsa 23, cité les pins","bla bla",102,true,23,1500,"week",5,2,3,"villa",null,null,null,o,null,null);
		houseTreatment.saveHouse(h);
    }


}
