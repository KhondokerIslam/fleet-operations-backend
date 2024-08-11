package com.example.BackendFleetOperations.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static LocalDate makeDateStandard( LocalDate localDate) {

        return LocalDate.parse(localDate.format( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) ), DateTimeFormatter.ofPattern( "dd/MM/yyyy" ));
    }

}
