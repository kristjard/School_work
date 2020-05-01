

import java.time.ZonedDateTime;

public class Scoool {

    public static void main(String[] args) throws IllegalAccessException {
        ZonedDateTime start_date = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        ZonedDateTime end_date = ZonedDateTime.parse("2020-12-31T00:00:00.000+00:00[UTC]");

        Course proov = new Course(start_date, end_date);
        System.out.println(proov.getWorkingDays());
    }
}
