package com.summerland.business;

import java.util.ArrayList;

import com.summerland.entities.Filter;
import com.summerland.entities.House;

public interface IBusinessHouse {

	public ArrayList<House> getHouses();

	public void saveHouse(House house);
	
	ArrayList<House> listHousesOfOwner(Long id);

	House getHouseById(Long id);

	ArrayList<House> filter_houses(Filter filter);
}
