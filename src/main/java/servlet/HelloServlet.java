package servlet;


import hello.Greeter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {
    Greeter greeter = new Greeter();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        String name = request.getParameter("name");

        String greeting = greeter.sayHello(name);

        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(greeting);

    }
    public void destroy() {
        // do nothing.
    }
}
