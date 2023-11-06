package edu.hw5;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"HideUtilityClassConstructor", "MagicNumber"})
public class Task2 {
    private final static String FRIDAY = "FRIDAY";

    public static List<LocalDate> findAllFridayThirteenOnYear(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        List<LocalDate> fridayThirteen = new LinkedList<>();
        while (date.getYear() == year) {
            if (date.getDayOfWeek().toString().equals(FRIDAY) && date.getDayOfMonth() == 13) {
                fridayThirteen.add(date);
            }

            date = date.plusDays(1);
        }

        return fridayThirteen;
    }
}
