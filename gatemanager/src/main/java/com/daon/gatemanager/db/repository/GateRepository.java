package com.daon.gatemanager.db.repository;

import com.daon.gatemanager.db.model.Gate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GateRepository extends CrudRepository<Gate, Long> {
    Optional<Gate> findByNumber(String number);

    List<Gate> findAllByAvailable(boolean available);

}
