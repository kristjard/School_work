package data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends PersonImpl {
    public Student(String first_name, String last_name, String preferred_name, ZonedDateTime date_of_birth,
                   List<Course> courses) {
        super(first_name, last_name, preferred_name, date_of_birth);
        this.courses = courses;
    }

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course>courses){
        this.courses = courses;
    }

    public List<String> showAllTeachersNames(List<Course> courses) {
        this.courses = courses;

        List<String> teachersNames = new ArrayList<String>();

        for (Course course : courses) {
            teachersNames.add(course.getTeacher().getLast_name());
        }

        return teachersNames;
    }

    public List<String> getAllTeacherNames(){
        return this.getCourses().stream().map(Course::getName).collect(Collectors.toList());
    }

    @Override
    public String sayHello() {

        return "Hello student " + getPreferred_name();
    }
}