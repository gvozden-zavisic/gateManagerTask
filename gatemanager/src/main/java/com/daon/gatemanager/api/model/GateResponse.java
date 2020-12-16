package com.daon.gatemanager.api.model;

import java.time.LocalTime;

public class GateResponse {

    private String gateNumber;
    private boolean available;
    private LocalTime unavailableFrom;
    private LocalTime unavailableTo;

    public GateResponse() {
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalTime getUnavailableFrom() {
        return unavailableFrom;
    }

    public void setUnavailableFrom(LocalTime unavailableFrom) {
        this.unavailableFrom = unavailableFrom;
    }

    public LocalTime getUnavailableTo() {
        return unavailableTo;
    }

    public void setUnavailableTo(LocalTime unavailableTo) {
        this.unavailableTo = unavailableTo;
    }
}
