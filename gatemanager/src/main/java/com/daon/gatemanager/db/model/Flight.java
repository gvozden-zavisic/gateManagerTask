package com.daon.gatemanager.db.model;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@ApiResponse
@Entity(name = "flight")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String number;
    @Column
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime arrivalTime;
    @Column
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime created;
    @Column
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime modified;
    @ManyToOne
    @JoinColumn(name = "gate_id", referencedColumnName = "id")
    private Gate gate;

    public Flight() {
        this.created = LocalDateTime.now();
    }

    public Flight(String number) {
        this.number = number;
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

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
