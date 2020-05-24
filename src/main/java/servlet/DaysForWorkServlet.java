package servlet;

import data.Course;
import data.Teatcher;
import utils.RandomCoursesGenerator;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

public class DaysForWorkServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {


        RandomCoursesGenerator randCourse = new RandomCoursesGenerator(47,100);
        List<Teatcher> teachers = randCourse.getListOfTeachers();
        List<Course> courses = randCourse.getListOfCourses();
        String workingDays;
        int reqCourseID = Integer.parseInt(request.getParameter("id"));
        int courseID = courses.get(reqCourseID - 1001).getCourseID();
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        if(courseID == reqCourseID){
            workingDays= Long.toString(courses.get(reqCourseID - 1001).getWorkingDays());
            response.getWriter().println("<html><h4>" + "Thank you! The provided course ID returns " + workingDays + " working days."+"</h4></html>");
        }
        else{
            response.getWriter().println("<html><h4>"+"Course not found!"+"</h4></html>");
        }
    }

}
