package com.eleos.app.service;

//CountryService.java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.eleos.app.db.Country;

public interface CountryService {
	Country createCountry(String name);
	Page<Country> getAllCountries(Pageable pageable);
	Country getCountryById(Long id);
	Country updateCountry(Long id, String newName);
	void deleteCountry(Long id);
}
