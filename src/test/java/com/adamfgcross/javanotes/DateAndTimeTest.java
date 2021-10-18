package com.adamfgcross.javanotes;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import static org.junit.jupiter.api.Assertions.*;

public class DateAndTimeTest {


    @Test
    void canCreateNew() {
        // java 8 introduced the new LocalDate, LocalTime, and LocalDateTime
        // as part of java.time package


        // create a LocalDate
        LocalDate localDate = LocalDate.now(); // the current machine's local date
        System.out.println("local date: " + localDate);
        assertTrue(localDate instanceof Temporal);

        LocalTime localTime = LocalTime.now();
        System.out.println("system time: " + localTime);
        assertTrue(localDate instanceof Temporal);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("system date-time: " + localDateTime);
        assertTrue(localDateTime instanceof Temporal);


        LocalDate localDate2 = LocalDate.of(2020, 07, 16);
    }

    @Test
    void getInfoFromLocalDate() {
        // get the 208th day of the year
        LocalDate localDate = LocalDate.ofYearDay(2021, 208);
        System.out.println(localDate.getMonth()); // prints "July"
        Month month = localDate.getMonth();
        assertEquals("JULY", localDate.getMonth().toString());

        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println("dayOfMonth: " + dayOfMonth);
        assertEquals(27, localDate.getDayOfMonth());

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("day of week: " + dayOfWeek.toString());
        assertEquals("TUESDAY", dayOfWeek.toString());
    }

    @Test
    void handleLeapDayYears() {
        // does the LocalDate.ofYearDay method handle leap years properly?
        LocalDate localDate = LocalDate.ofYearDay(2020, 31+29);
        Month month = localDate.getMonth();
        assertEquals("FEBRUARY", month.toString());
        System.out.println(month);
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println("dayOfMonth: " + dayOfMonth);
        assertEquals(29, dayOfMonth);
    }

    @Test
    void handleGetDayOfYear() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getDayOfYear());
    }

    @Test
    void useChronoField() {
        LocalDate localDate = LocalDate.of(2020, 2, 29);
        int dayOfMonth = localDate.get(ChronoField.DAY_OF_MONTH);
        assertEquals(29, dayOfMonth);
    }

    @Test
    void modifyingExistingDate() {
        // using the plusDays method creates a new LocalDate instance
        // LocalDate is immutable, so we really do not modify it
        LocalDate localDate = LocalDate.of(2020, 2, 29);
        LocalDate localDate1 = localDate.plusDays(37);
        System.out.println(localDate);
        System.out.println(localDate1);
        assertNotEquals(localDate, localDate1);
    }

    @Test
    void makeLocalTime() {
        LocalTime localTime = LocalTime.of(8, 15);
        LocalDate localDate = LocalDate.of(2020, 2, 29);
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(localDateTime);
        System.out.println(localTime);
    }

    @Test
    void lookAtMidnight() {
        LocalTime localTime = LocalTime.MIDNIGHT;
        System.out.println(localTime);
    }

    @Test
    void weirdCases() {

        assertThrows(DateTimeException.class, ()->{
            //February 31
            LocalDate localDate = LocalDate.of(2020, 2, 31);
        });


        assertThrows(DateTimeException.class, ()->{
            //February 31
            LocalDate localDate = LocalDate.of(2020, 2, 12);
            LocalDate localDate2 = localDate.minus(1, ChronoUnit.HOURS);
        });

        assertDoesNotThrow(() -> {

            LocalDate localDate = LocalDate.of(2020, 2, 12);
            LocalDate localDate2 = localDate.minus(1, ChronoUnit.DAYS);
        });
    }

    @Test
    void localTimeExample_1() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    @Test
    void localTimeExample_2() {
        LocalTime localTime = LocalTime.of(8,15);
        System.out.println(localTime);
        LocalDate localDate = LocalDate.of(2020, Month.JANUARY, 5);

        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 1, 5, 8, 15);
        assertEquals(localDateTime1, localDateTime);
        assertTrue(localDateTime.isEqual(localDateTime1));
        assertTrue(localDateTime.equals(localDateTime1));

    }

}
