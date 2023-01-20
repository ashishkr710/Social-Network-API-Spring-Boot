package com.example.social.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LocationService {

	  @Autowired
	  LocationRepo locationRepo;
	  
	  public List<Location> getAllLocation(){
			return (List<Location>)locationRepo.findAll();
		}
	  
	  public Location getLocation(String id) {
		  return locationRepo.findById(id).get();

	  }
	  public void addLocation(Location location) {
		  locationRepo.save(location);
	  }
	  public void updateLocation(Location location, String id) {
		  Location loc = locationRepo.findById(id).get();
		  loc.setName(location.getName());
		  locationRepo.save(loc);
	  }
	  public void deleteLocation(String id) {
		  locationRepo.delete(locationRepo.findById(id).get());
	  }
}
