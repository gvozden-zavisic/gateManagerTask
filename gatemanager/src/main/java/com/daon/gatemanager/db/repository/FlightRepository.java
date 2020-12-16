package com.daon.gatemanager.db.repository;

import com.daon.gatemanager.db.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    Optional<Flight> findByNumber(String number);
}
