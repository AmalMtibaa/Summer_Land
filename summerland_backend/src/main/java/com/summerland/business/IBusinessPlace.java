package com.summerland.business;

import com.summerland.entities.Place;

import java.util.ArrayList;

public interface IBusinessPlace {

	void savePlace(Place place);

	ArrayList<Place> getPlaces();
}
