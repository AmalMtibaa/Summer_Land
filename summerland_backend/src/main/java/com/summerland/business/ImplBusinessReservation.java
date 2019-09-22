package com.summerland.business;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.summerland.entities.House;
import com.summerland.entities.Reservation;
import com.summerland.repositories.HouseRepository;
import com.summerland.repositories.ReservationRepository;

@Service
@Transactional
public class ImplBusinessReservation implements IBusinessReservation{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public ArrayList<Reservation> listReservationsOfHouse(Long id) {
		ArrayList<Reservation> res = reservationRepository.findReservationsByHouseId(id);
		return res;
	}
	

	@Override
	public ArrayList<Reservation> listHouses_confirmer(Long id) {
		ArrayList<Reservation> res = reservationRepository.findConfirmedHouses(id);
		return res;
	}

	@Override
	public ArrayList<Reservation> listHouses_attendre(Long id) {
		ArrayList<Reservation> res = reservationRepository.findWaitingHouses(id);
		return res;
	}

	@Override
	public void saveReservation(Reservation r){
		reservationRepository.save(r);
	}

	@Override
	public void acceptReservation(Long id) {
		reservationRepository.acceptReservationById(id,"confirmer");

	}

	@Override
	public void refuseReservation(Long id) {
		reservationRepository.refuseReservationById(id,"refuser");

	}

	@Override
	public Reservation getReservation(Long l) {
		Optional<Reservation> ress =  reservationRepository.findById(l);
		Reservation res=null;
		if(ress.isPresent())
			res = ress.get();
		return res;
	}

	@Override
	public ArrayList<Reservation> listReservationsOfCustomer(Long id){
		return reservationRepository.getReservationByCustomerId(id);
	}


}
