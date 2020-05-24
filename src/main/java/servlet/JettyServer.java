package servlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;


public class JettyServer {
    private Server server;

    public void start() throws Exception {
        try {
            server = new Server();
            ServerConnector connector = new ServerConnector(server);
            connector.setPort(1330);
            server.setConnectors(new Connector[]{connector});

            ServletHandler servletHandler = new ServletHandler();
            server.setHandler(servletHandler);

            servletHandler.addServletWithMapping(HelloServlet.class, "/hello");
            servletHandler.addServletWithMapping(CourseListServlet.class, "/cl");
            servletHandler.addServletWithMapping(DaysForWorkServlet.class, "/dfw");

            server.start();
        } catch (Exception ex) {
            System.out.println("miskit on mäda");
            System.out.println(ex.getMessage());
        }
    }


    public void stop() throws Exception {
        server.stop();
    }

}