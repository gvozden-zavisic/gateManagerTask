package com.daon.gatemanager.security;

import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.custom_exeptions.UnauthorizedException;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class APIKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    private String principalRequestHeader;

    public APIKeyAuthFilter(String principalRequestHeader) {
        this.principalRequestHeader = principalRequestHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        if (request.getHeader(principalRequestHeader) == null)
            throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_ACCESS);
        return request.getHeader(principalRequestHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        return "N/A";
    }

}