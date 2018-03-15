package org.arpit.java2blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.arpit.java2blog.bean.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	@RequestMapping(value="/countries",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Country> getCountries(){
	  List<Country> listOfCountries = new ArrayList<Country>();
	  listOfCountries=createCountryList();
	  return listOfCountries;
	}
	
	 public List<Country> createCountryList(){
		 
	  Country indiaCountry=new Country(1, "India");
	  Country chinaCountry=new Country(4, "China");
	  Country nepalCountry=new Country(3, "Nepal");
	  Country bhutanCountry=new Country(2, "Bhutan");
	 
	  List<Country> listOfCountries = new ArrayList<Country>();
	  listOfCountries.add(indiaCountry);
	  listOfCountries.add(chinaCountry);
	  listOfCountries.add(nepalCountry);
	  listOfCountries.add(bhutanCountry);
	  return listOfCountries;
	 }
}
