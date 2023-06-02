package com.techelevator.farm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Farm {

    private static final DateTimeFormatter harvestDateFormatter = DateTimeFormatter.ofPattern("(QQQQ) EEEE MMM dd yyyy");
    public static String getHarvestDate(int plantingMonth, int plantingDay, int growthInDays) {
            LocalDate harvestDate = LocalDate.of(LocalDate.now().getYear(),
                    plantingMonth, plantingDay).plusDays(growthInDays);
            return harvestDate.format(harvestDateFormatter);
    }

    private String name;

    public String getName() {
        return name;
    }
}
