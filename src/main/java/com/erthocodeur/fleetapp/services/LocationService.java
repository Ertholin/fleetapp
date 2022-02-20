package com.erthocodeur.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erthocodeur.fleetapp.models.Location;
import com.erthocodeur.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	//Return list of locations
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	//Save a new Location
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	//Get By id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
		
	}


}
