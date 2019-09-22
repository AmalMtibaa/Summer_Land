package com.summerland.repositories;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.summerland.entities.House;

public interface HouseRepository  extends JpaRepository<House, Long>{

	@Query("select h from House h where h.owner.id=:x ORDER BY h.id DESC")
	ArrayList<House> findHouses(@Param("x") Long id);

}
