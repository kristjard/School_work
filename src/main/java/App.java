import data.Course;
import servlet.JettyServer;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] Args){

        JettyServer server = new JettyServer();
        Course course = new Course()
        List<Course> courses = new ArrayList<>();

        for(Course c : courses){

        }

        try {
            server.start();
        }
        catch (Exception ex){
            System.out.println("ettenägematu puue");
        }

    }
}
