package data;

import utils.RandomCoursesGenerator;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Scoool {

    public static void main(String[] args) {
            ZonedDateTime start_date = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        ZonedDateTime end_date = ZonedDateTime.parse("2020-12-31T00:00:00.000+00:00[UTC]");
        Teatcher uudo = new Teatcher("Uudo","Uudishimulik","Unts", start_date);
        Course at = new Course(1,"Astronoomiline teleportatsioon", uudo, start_date, end_date, 20);
        List<Course> courses = new ArrayList<Course>();
        courses.add(at);

        Student mati = new Student("Mathias", "Maasikas", "matu",
                ZonedDateTime.parse("2000-01-01T00:00:00.000+00:00[UTC]"),courses);

        RandomCoursesGenerator rndc = new RandomCoursesGenerator(75,250);
        rndc.getListOfTeachers();
        System.out.print(rndc.getListOfCourses());
        System.out.println(at);
    }
}
