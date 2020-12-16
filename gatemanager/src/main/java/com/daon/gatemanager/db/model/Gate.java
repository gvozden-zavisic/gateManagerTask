package com.daon.gatemanager.db.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

@Entity(name = "gate")
public class Gate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String number;
    @Column
    private boolean available;
    @Column
//    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalTime unavailableFrom;
    @Column
//    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalTime unavailableTo;
    @Column
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime created;
    @Column
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime modified;
    @OneToMany(mappedBy = "gate")
    private Collection<Flight> flight;

    public Gate() {
        this.created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
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

    public Collection<Flight> getFlight() {
        return flight;
    }

    public void setFlight(Collection<Flight> flight) {
        this.flight = flight;
    }
}
