package net.asforil.AtmWeb.service;

import java.util.List;

import net.asforil.AtmWeb.model.Atm;

public interface AtmWebService {
	
	List<Atm> getAllAtm();
	
	List<Atm> searchAtm(Atm searchAtm);

}
