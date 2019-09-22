package com.summerland.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.summerland.entities.House;
import com.summerland.entities.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Long>{

	@Query("select r from Reservation r where r.house.id=:x ORDER BY r.id DESC")
	ArrayList<Reservation> findReservationsByHouseId(@Param("x") Long id);

	@Query("select r from Reservation r  where r.confirmation like 'confirmer' and r.house.id=:x")
	ArrayList<Reservation> findConfirmedHouses(@Param("x") Long id);

	@Query("select r from Reservation r  where r.confirmation like 'attendre' and r.house.id=:x")
	ArrayList<Reservation> findWaitingHouses(@Param("x") Long id);

	@Modifying
	@Query("update Reservation r set r.confirmation=:y where r.id =:x")
	void acceptReservationById(@Param("x") Long id, @Param("y") String conf);

	@Modifying
	@Query("update Reservation r set r.confirmation=:y where r.id =:x")
	void refuseReservationById(@Param("x") Long id,@Param("y") String conf);

	@Query("select r from Reservation r  where r.customer.id=:x")
	ArrayList<Reservation> getReservationByCustomerId(@Param("x") Long id);


}//like %:x%
