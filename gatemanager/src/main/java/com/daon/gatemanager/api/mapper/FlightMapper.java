package com.daon.gatemanager.api.mapper;

import com.daon.gatemanager.api.model.FlightResponse;
import com.daon.gatemanager.db.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightMapper {
    FlightMapper MAPPER = Mappers.getMapper(FlightMapper.class);

    @Mapping(target = "gateNumber", source = "gate.number")
    @Mapping(target = "flightNumber", source = "number")
    FlightResponse map(Flight flight);

}
