package edu.hw5;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"HideUtilityClassConstructor", "MagicNumber"})
public class Task2 {
    private final static String FRIDAY = "FRIDAY";

    public static LocalDate findAllFridayThirteenOnYear(LocalDate localDate) {
        LocalDate date;
        if (localDate.getDayOfMonth() <= 13) {
            date = localDate.withDayOfMonth(13);
        } else {
            date = localDate.with(TemporalAdjusters.firstDayOfNextMonth()).withDayOfMonth(13);
        }

        while (true) {
            if (date.getDayOfWeek().toString().equals(FRIDAY)) {
                return date;
            }
            date = date.with(TemporalAdjusters.firstDayOfNextMonth()).withDayOfMonth(13);
        }
    }

    public static List<LocalDate> findAllFridayThirteenOnYear(int year) {
        List<LocalDate> fridayThirteen = new LinkedList<>();
        LocalDate date = LocalDate.of(year, 1, 13);
        while (date.getYear() == year) {
            if (date.getDayOfWeek().toString().equals(FRIDAY)) {
                fridayThirteen.add(date);
            }

            date = date.with(TemporalAdjusters.firstDayOfNextMonth()).withDayOfMonth(13);
        }

        return fridayThirteen;
    }
}
