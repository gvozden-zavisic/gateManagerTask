package com.daon.gatemanager.db.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Converter
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime locDateTime) {
        return locDateTime == null ? null : Date.from(locDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dateTime) {
        return dateTime == null ? null : dateTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}