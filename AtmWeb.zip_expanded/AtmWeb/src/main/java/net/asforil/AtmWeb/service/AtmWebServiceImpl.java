package net.asforil.AtmWeb.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.asforil.AtmWeb.model.Atm;



@Service
public class AtmWebServiceImpl implements AtmWebService{
	
	
	@Autowired	
	private RestTemplate restTemplate;
	
	private String url = "http://localhost:8080/allAtm";
	
	
	public List<Atm> getAllAtm() {
		
		
		Atm[] arrayAtm = restTemplate.getForObject(url, Atm[].class);
		List<Atm> listAtm = Arrays.asList(arrayAtm);
		return listAtm;		
	}
	

	
	public List<Atm> searchAtm(Atm searchAtm) {		
		Atm[] arrayAtm = restTemplate.getForObject(url, Atm[].class);
		List<Atm> listAtm = Arrays.asList(arrayAtm);
						
	    Stream<Atm> stream = listAtm.stream();
		if(!searchAtm.getAddress().getStreet().equals("")) {
			stream = stream.filter(atm -> atm.getAddress().getStreet().equalsIgnoreCase(searchAtm.getAddress().getStreet()));
		}
		if(!searchAtm.getAddress().getHousenumber().equals("")) {
			stream = stream.filter(atm -> atm.getAddress().getHousenumber().equalsIgnoreCase(searchAtm.getAddress().getHousenumber()));
		}
		if(!searchAtm.getAddress().getPostalcode().equals("")) {
			stream = stream.filter(atm -> atm.getAddress().getPostalcode().equalsIgnoreCase(searchAtm.getAddress().getPostalcode()));
		}
		if(!searchAtm.getAddress().getCity().equals("")) {
			stream = stream.filter(atm -> atm.getAddress().getCity().equalsIgnoreCase(searchAtm.getAddress().getCity()));
		}		
		if(searchAtm.getAddress().getGeoLocation().getLat() != 0.0 ) {
			stream = stream.filter(atm -> atm.getAddress().getGeoLocation().getLat() == searchAtm.getAddress().getGeoLocation().getLat());
		}
		if(searchAtm.getAddress().getGeoLocation().getLng() != 0.0) {
			stream = stream.filter(atm -> atm.getAddress().getGeoLocation().getLng() == searchAtm.getAddress().getGeoLocation().getLng());
		}
		
		
		List<Atm> listAfterSearch = stream.collect(Collectors.toList());		
		return listAfterSearch;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
