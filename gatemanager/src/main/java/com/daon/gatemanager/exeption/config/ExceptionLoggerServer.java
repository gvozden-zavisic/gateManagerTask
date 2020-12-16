package com.daon.gatemanager.exeption.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("serverLogger")
public class ExceptionLoggerServer implements ExceptionLogger {

    private static final Logger log = LoggerFactory.getLogger(ExceptionLoggerServer.class);

    @Override
    public void error(Exception ex) {
        log.error("INTERNAL", ex);
    }

    @Override
    public void error(String s) {
        log.error("CUSTOM_INTERNAL", s);
    }

    @Override
    public void error(String s, Exception ex) {
        log.error(s, ex);
    }
}
