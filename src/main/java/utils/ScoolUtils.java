package utils;

import data.Student;

import java.util.List;

public class ScoolUtils {
    public ScoolUtils() {
    }

    public static void printStudents(List<Student> students){
        for(Student s: students){
            System.out.println(s.getPreferred_name());
        }
    }
}
