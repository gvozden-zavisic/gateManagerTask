package com.daon.gatemanager.api.model;

import java.time.LocalTime;

public class GatePatchRequest {

    private Boolean available;
    private LocalTime unavailableFrom;
    private LocalTime unavailableTo;

    public GatePatchRequest() {
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
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
