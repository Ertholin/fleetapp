package com.erthocodeur.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erthocodeur.fleetapp.models.Vehicle;
import com.erthocodeur.fleetapp.services.EmployeeService;
import com.erthocodeur.fleetapp.services.LocationService;
import com.erthocodeur.fleetapp.services.VehicleMakeService;
import com.erthocodeur.fleetapp.services.VehicleModelService;
import com.erthocodeur.fleetapp.services.VehicleService;
import com.erthocodeur.fleetapp.services.VehicleStatusService;
import com.erthocodeur.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController {

	@Autowired private VehicleService vehicleService;
	@Autowired private VehicleTypeService vehicleTypeService;
	@Autowired private VehicleMakeService vehicleMakeService;
	@Autowired private VehicleModelService vehicleModelService;
	@Autowired private LocationService locationService;
	@Autowired private EmployeeService employeeService ;
	@Autowired private VehicleStatusService vehicleStatusService;


	//Get All Vehicles
	@GetMapping("vehicles")
	public String findAll(Model model){		
		model.addAttribute("vehicles", vehicleService.findAll());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuss());

		return "vehicle";
	}	
	
	@RequestMapping("vehicles/findById") 
	@ResponseBody
	public Optional<Vehicle> findById(Integer id)
	{
		return vehicleService.findById(id);
	}
	
	//Add Vehicle
	@PostMapping(value="vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}	
	
	@RequestMapping(value="vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value="vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}
	
}
