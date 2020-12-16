package com.daon.gatemanager.db.service;

import com.daon.gatemanager.db.model.Flight;
import com.daon.gatemanager.db.model.Gate;
import com.daon.gatemanager.db.repository.FlightRepository;
import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.custom_exeptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    @Autowired
    private GateService gateService;

    public Flight getByNumber(String number) {
        return repository.findByNumber(number).orElseThrow(() -> new EntityNotFoundException(ErrorCode.FLIGHT_MISS));
    }

    public Flight save(Flight flight) {
        return repository.save(flight);
    }

    public Flight checkGate(Flight flight) {
        Gate gate = flight.getGate();
        LocalTime time = LocalTime.now();

        if (!gate.isAvailable() || !gateService.isAvailableByTime(time, gate)) {
            gate = gateService.findFirstByAvailable(time);
            flight.setGate(gate);
            flight.setModified(LocalDateTime.now());
            return save(flight);
        }
        return flight;
    }
}
