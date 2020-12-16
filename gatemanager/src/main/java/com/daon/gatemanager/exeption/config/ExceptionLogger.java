package com.daon.gatemanager.exeption.config;

public interface ExceptionLogger {

    void error(Exception ex);

    void error(String s);

    void error(String s, Exception ex);
}
