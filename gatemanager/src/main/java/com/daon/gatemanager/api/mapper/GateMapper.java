package com.daon.gatemanager.api.mapper;

import com.daon.gatemanager.api.model.GateResponse;
import com.daon.gatemanager.db.model.Gate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GateMapper {
    GateMapper MAPPER = Mappers.getMapper(GateMapper.class);

    @Mapping(target = "gateNumber", source = "number")
    GateResponse map(Gate gate);

}
