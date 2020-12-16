package com.daon.gatemanager.api.controller;

import com.daon.gatemanager.api.mapper.FlightMapper;
import com.daon.gatemanager.api.model.ApiResponse;
import com.daon.gatemanager.api.model.ApiResponseCode;
import com.daon.gatemanager.db.model.Flight;
import com.daon.gatemanager.db.service.FlightService;
import com.daon.gatemanager.db.service.GateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/gatemanager/flights")
public class FlightRestEndpoint {

    private static final Logger log = LoggerFactory.getLogger(FlightRestEndpoint.class);

    @Autowired
    private FlightService flightService;

    @Autowired
    private GateService gateService;

    @GetMapping
    @Operation(summary = "get gate by number", security = @SecurityRequirement(name = "bearerAuth"))
    public @ResponseBody
    ApiResponse getFootprintById(HttpServletRequest servletRequest, @RequestParam String number

    ) {
        log.info("{} {}", servletRequest.getServletPath(), number);

        Flight flight = flightService.getByNumber(number);
        flightService.checkGate(flight);

        return new ApiResponse(FlightMapper.MAPPER.map(flight), ApiResponseCode.FLIGHT_GATE_AVAILABLE);
    }

}