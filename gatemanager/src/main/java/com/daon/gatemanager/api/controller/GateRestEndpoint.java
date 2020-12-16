package com.daon.gatemanager.api.controller;

import com.daon.gatemanager.api.mapper.GateMapper;
import com.daon.gatemanager.api.model.ApiResponse;
import com.daon.gatemanager.api.model.ApiResponseCode;
import com.daon.gatemanager.api.model.GatePatchRequest;
import com.daon.gatemanager.db.model.Gate;
import com.daon.gatemanager.db.service.GateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/gatemanager/gates")
public class GateRestEndpoint {

    private static final Logger log = LoggerFactory.getLogger(GateRestEndpoint.class);

    @Autowired
    private GateService gateService;

    @PatchMapping("/{id}")
    @Operation(summary = "update gate", security = @SecurityRequirement(name = "bearerAuth"))
    public @ResponseBody
    ApiResponse getGateById(@RequestBody GatePatchRequest request, HttpServletRequest servletRequest, @PathVariable String id
    ) {
        log.info("{} {}", servletRequest.getServletPath(), id);

        Gate gate = gateService.getByNumber(id);

        gate.setAvailable(request.getAvailable() != null ? request.getAvailable() : gate.isAvailable());
        gate.setUnavailableFrom(request.getUnavailableFrom() != null ? request.getUnavailableFrom() : gate.getUnavailableFrom());
        gate.setUnavailableTo(request.getUnavailableTo() != null ? request.getUnavailableTo() : gate.getUnavailableTo());
        gate.setModified(LocalDateTime.now());

        gateService.save(gate);

        return new ApiResponse(GateMapper.MAPPER.map(gate), ApiResponseCode.GATE_UPDATED);
    }

}