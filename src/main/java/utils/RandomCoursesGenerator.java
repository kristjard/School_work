package utils;

import data.Course;
import data.Teatcher;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomCoursesGenerator {
    private int nrOfTeachers;
    private int nrOfCourses;

    public RandomCoursesGenerator(int nrOfTeachers, int nrOfCourses) {
        this.nrOfTeachers = nrOfTeachers;
        this.nrOfCourses = nrOfCourses;
    }

    public int getNrOfTeachers() {
        return nrOfTeachers;
    }

    public void setNrOfTeachers(int nrOfTeachers) {
        this.nrOfTeachers = nrOfTeachers;
    }

    public int getNrOfCourses() {
        return nrOfCourses;
    }

    public void setNrOfCourses(int nrOfCourses) {
        this.nrOfCourses = nrOfCourses;
    }

    Random rand = new Random();
    List<Course> courses = new ArrayList<>();
    List<Teatcher> teatchers = new ArrayList<>();
    List<String> firstNames = Arrays.asList("Anna", "Mati", "Aino", "Uudo", "Eedi", "Mafalda", "Joanna", "Teresa",
            "Joao", "Toomas");
    List<String> lastNames = Arrays.asList("Ribeiro", "Uibo", "Urb", "Roberto", "Uudishimulik", "Vana", "Valge",
            "Alberto", "Lopo", "Hunt");
    List<String> preferredNames = Arrays.asList("Loco", "Julmkutt", "Arukas", "sekspomm", "Kyle", "Sol", "Flor");
    List<String> courseNames = Arrays.asList("Portugues", "Eesti keel", "Astrofüüsika", "Masinõpe", "Varia teadmised",
            "Kolmanda silma avamine 101", "Chakrad ja miks?", "Kuidas varem magama minna", "Kiirkudumine", "Metallurgia");
    List<ZonedDateTime> birthDates = Arrays.asList(ZonedDateTime.parse("1970-01-01T00:00:00.000+00:00[UTC]"),
            ZonedDateTime.parse("1980-01-01T00:00:00.000+00:00[UTC]"),
            ZonedDateTime.parse("1990-01-01T00:00:00.000+00:00[UTC]"),
            ZonedDateTime.parse("1975-01-01T00:00:00.000+00:00[UTC]"),
            ZonedDateTime.parse("1988-01-01T00:00:00.000+00:00[UTC]"));
    List<ZonedDateTime> dates = Arrays.asList(ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]"),
            ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]"),
            ZonedDateTime.parse("2020-03-01T00:00:00.000+00:00[UTC]"),
            ZonedDateTime.parse("2020-04-01T00:00:00.000+00:00[UTC]"),
            ZonedDateTime.parse("2020-05-01T00:00:00.000+00:00[UTC]"));

    public List<Teatcher> getListOfTeachers(){
        for(int i = 0; i <= nrOfTeachers; i++){
            String randFirstName = firstNames.get(rand.nextInt(firstNames.size()));
            String randLastName = lastNames.get(rand.nextInt(lastNames.size()));
            String randPreferredName = preferredNames.get(rand.nextInt(preferredNames.size()));
            ZonedDateTime randBirthDate = birthDates.get(rand.nextInt(birthDates.size()));

            teatchers.add(new Teatcher(randFirstName, randLastName, randPreferredName, randBirthDate));
        }
        return teatchers;
    }

    public List<Course> getListOfCourses(){
        for(int j = 0; j <= nrOfCourses; j++ ){
            int randDate = rand.nextInt((dates.size()));
            String randCourseName = courseNames.get(rand.nextInt(courseNames.size()));
            Teatcher randTeacher = teatchers.get(rand.nextInt(teatchers.size()));
            ZonedDateTime randStartDate = dates.get(randDate);
            //ZonedDateTime randEndDate = dates.get(randDate + 1);
            int randEap = rand.ints(2, 11).findFirst().getAsInt();

            courses.add(new Course(1000 + j, randCourseName, randTeacher, randStartDate, randStartDate.plusMonths(randEap/2), randEap));

        }
        return courses;
    }


}
