package servlet;

import data.Course;
import data.Teatcher;
import utils.RandomCoursesGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseListServlet extends HttpServlet {
    RandomCoursesGenerator randCourse = new RandomCoursesGenerator(47,100);
    List<Teatcher> teachers = randCourse.getListOfTeachers();
    List<Course> courses = randCourse.getListOfCourses();
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //String coursesLister = request.getParameter("cList");
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        for (Course c : courses){
            response.getWriter().println("<html><h4>"+c.toString()+"</h4></html>");
        }

    }


}
