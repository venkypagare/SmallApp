package com.eleos.app.service;

import org.springframework.stereotype.Service;
import com.eleos.app.db.Country;
import com.eleos.app.exception.ResourceNotFoundException;
import com.eleos.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class CountryServiceImpl implements CountryService {

 @Autowired
 private CountryRepository countryRepository;

 @Override
 public Country createCountry(String name) {
     Country country = new Country();
     country.setName(name);
     return countryRepository.save(country);
 }

 @Override
 public Page<Country> getAllCountries(Pageable pageable) {
     return countryRepository.findAll(pageable);
 }

 @Override
 public Country getCountryById(Long id) {
     return countryRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Country not found with id " + id));
 }

 @Override
 public Country updateCountry(Long id, String newName) {
     Country country = getCountryById(id);
     country.setName(newName);
     return countryRepository.save(country);
 }

 @Override
 public void deleteCountry(Long id) {
     Country country = getCountryById(id);
     countryRepository.delete(country);
 }
}
