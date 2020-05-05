package data;

import org.junit.Test;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    ZonedDateTime start_date = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime end_date = ZonedDateTime.parse("2020-03-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime date_of_birth_t = ZonedDateTime.parse("1950-01-01T00:00:00.000+00:00[UTC]");
    Teatcher teatcher = new Teatcher("Uudo", "Uudishimulik", "Unts",
            date_of_birth_t);
    Course course = new Course("Astronoomiline Teleportatsioon",teatcher, start_date, end_date, 20);
    private List<Course> courses = new ArrayList<>();

    ZonedDateTime date_of_birth = ZonedDateTime.parse("2000-01-01T00:00:00.000+00:00[UTC]");
    Student student = new Student("Mathias", "Maasikas", "Matu",
            date_of_birth, courses);
    @Test
    public void sayHelloTest() {
        //given
        courses.add(course);
        String expected_result = "Hello student Matu";
        //when
        String result = student.sayHello();
        //then
        assertEquals(expected_result, result);
    }
    @Test
    public void showAllTeatchersNamesTest(){
        //given
        List expected_result = new ArrayList();
        expected_result.add("Uudishimulik");
        //when
        courses.add(course);
        List result = student.showAllTeachersNames(courses);
        //then
        assertEquals(expected_result, result);


    }
    @Test
    public void getAllTeatchersNamesTest(){
        //given
        List expected_result = new ArrayList();
        expected_result.add("Astronoomiline Teleportatsioon");
        //when
        courses.add(course);
        List result = student.getAllTeacherNames();
        //then
        assertEquals(expected_result, result);
    }
}
