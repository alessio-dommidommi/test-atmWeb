package net.asforil.AtmWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import net.asforil.AtmWeb.model.Address;
import net.asforil.AtmWeb.model.Atm;
import net.asforil.AtmWeb.model.GeoLocation;
import net.asforil.AtmWeb.service.AtmWebService;

@Controller
public class AtmWebController {
	
	@Autowired
	private AtmWebService service;
	
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}
	
	
	@GetMapping("/atms")
	public ModelAndView getAllAtm() {
		ModelAndView model = new ModelAndView();
		model.setViewName("listAtm");
		List<Atm> listAtm = service.getAllAtm();
		model.addObject("listAtm", listAtm);
		
		Atm searchAtm = new Atm();
		Address address = new Address();
		GeoLocation geoLocation = new GeoLocation();
		address.setGeoLocation(geoLocation);
		searchAtm.setAddress(address);
		model.addObject("searchAtm", searchAtm);
		
		return model;
	}
	
	@PostMapping("/searchAtm")
	public ModelAndView searchAtm( Atm searchAtm) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("listAtm");		
		List<Atm> listAtm = service.searchAtm(searchAtm);		
		model.addObject("listAtm", listAtm);	
		
		Atm atm = new Atm();
		Address address = new Address();
		GeoLocation geoLocation = new GeoLocation();
		address.setGeoLocation(geoLocation);
		atm.setAddress(address);
		model.addObject("searchAtm", atm);
		return model;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
