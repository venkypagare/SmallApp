package com.eleos.app.repository;

//CountryRepository.java
import org.springframework.data.repository.PagingAndSortingRepository;

import com.eleos.app.db.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}