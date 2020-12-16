package com.daon.gatemanager.db.service;

import com.daon.gatemanager.db.model.Gate;
import com.daon.gatemanager.db.repository.GateRepository;
import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.custom_exeptions.EntityNotFoundException;
import com.daon.gatemanager.exeption.custom_exeptions.GateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class GateService {

    @Autowired
    private GateRepository repository;

    public Gate getByNumber(String number) {
        return repository.findByNumber(number).orElseThrow(() -> new EntityNotFoundException(ErrorCode.GATE_MISS));
    }

    public Gate findFirstByAvailable(LocalTime time) {
        return repository.findAllByAvailable(true).stream().filter(g -> isAvailableByTime(time, g)).findFirst()
                .orElseThrow(() -> new GateException(ErrorCode.GATE_UNAVAILABLE));
    }

    public boolean isAvailableByTime(LocalTime now, Gate gate) {
        return (gate.getUnavailableFrom() == null || gate.getUnavailableTo() == null) ||
                !(now.isAfter(gate.getUnavailableFrom()) && now.isBefore(gate.getUnavailableTo()));
    }

    public Gate save(Gate gate) {
        return repository.save(gate);
    }

}
