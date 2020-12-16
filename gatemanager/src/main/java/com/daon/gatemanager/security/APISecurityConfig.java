package com.daon.gatemanager.security;

import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.config.FilterChainExceptionHandler;
import com.daon.gatemanager.exeption.custom_exeptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;

@Configuration
@EnableWebSecurity
@Order(1)
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FilterChainExceptionHandler filterChainExceptionHandler;

    @Value("${daon.apikey.name}")
    private String principalRequestHeader;

    @Value("${daon.apikey.value}")
    private String principalRequestValue;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/daon/swagger/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
        filter.setAuthenticationManager(new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) {
                String principal = (String) authentication.getPrincipal();
                if (!principalRequestValue.equals(principal)) {
                    throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_ACCESS);
                }
                authentication.setAuthenticated(true);
                return authentication;
            }
        });

        httpSecurity.addFilterBefore(filterChainExceptionHandler, APIKeyAuthFilter.class).
                antMatcher("/api/**").
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
    }

}