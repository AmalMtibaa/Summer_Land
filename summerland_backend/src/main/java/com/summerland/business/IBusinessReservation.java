package com.summerland.business;

import java.util.ArrayList;

import com.summerland.entities.House;
import com.summerland.entities.Reservation;

public interface IBusinessReservation {

	ArrayList<Reservation> listReservationsOfHouse(Long id);

	ArrayList<Reservation> listReservationsOfCustomer(Long id);
	
	ArrayList<Reservation> listHouses_confirmer(Long id); //list_Confirmed_Reservations
	
	ArrayList<Reservation> listHouses_attendre(Long id); //lise_Reservations_Request

	void saveReservation(Reservation r);

	void acceptReservation(Long id);

	void refuseReservation(Long id);

	Reservation getReservation(Long id);



}
