package com.firstcoding.mvc.springmvc.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        // 문자타입 날짜를 받아서 LocalDate 타입으로 변환하여 반환한다!

        return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")); // 전달받은 text를 원하는 날짜 패턴으로 parse한다.
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
    }
}
