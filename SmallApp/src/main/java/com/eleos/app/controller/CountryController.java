package com.eleos.app.controller;

import org.springframework.web.bind.annotation.RestController;
import com.eleos.app.db.Country;
import com.eleos.app.payload.CountryRequest;
import com.eleos.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

 @Autowired
 private CountryService countryService;

 // http://localhost:8080/api/countries
 @PostMapping
 public ResponseEntity<Country> createCountry(@RequestBody CountryRequest countryRequest) {
     Country country = countryService.createCountry(countryRequest.getName());
     return new ResponseEntity<>(country, HttpStatus.CREATED);
 }

//http://localhost:8080/api/countries
 @GetMapping
 public ResponseEntity<Page<Country>> getAllCountries(
         @RequestParam(defaultValue = "0") int page,
         @RequestParam(defaultValue = "5") int size) {
     Page<Country> countries = countryService.getAllCountries(PageRequest.of(page, size));
     return new ResponseEntity<>(countries, HttpStatus.OK);
 }

//http://localhost:8080/api/countries/1
 @GetMapping("/{id}")
 public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
     Country country = countryService.getCountryById(id);
     return new ResponseEntity<>(country, HttpStatus.OK);
 }

//http://localhost:8080/api/countries/1
 @PutMapping("/{id}")
 public ResponseEntity<Country> updateCountry(
         @PathVariable Long id,
         @RequestBody CountryRequest countryRequest) {
     Country updatedCountry = countryService.updateCountry(id, countryRequest.getName());
     return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
 }

 // http://localhost:8080/api/countries/1
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
     countryService.deleteCountry(id);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
}
