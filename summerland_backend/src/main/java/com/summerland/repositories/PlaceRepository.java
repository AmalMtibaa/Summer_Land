package com.summerland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerland.entities.Place;

public interface PlaceRepository  extends JpaRepository<Place, Long>{

}
