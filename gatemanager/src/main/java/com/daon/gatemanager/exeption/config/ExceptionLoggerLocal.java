package com.daon.gatemanager.exeption.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("localLogger")
public class ExceptionLoggerLocal implements ExceptionLogger {

    @Override
    public void error(Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void error(String s) {
        System.out.println(s);
    }

    @Override
    public void error(String s, Exception ex) {
        System.out.println(s);
        ex.printStackTrace();
    }
}
