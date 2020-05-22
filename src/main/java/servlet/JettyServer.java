package servlet;

import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class JettyServer {
    private Server server;

    public void start() throws Exception {
        int maxThreads = 100;
        int minThreads = 20;
        int idleTimeout = 120;

        QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);

        server = new Server(threadPool);
        ServerConnector connector = new ServerConnector(server, new HttpConnectionFactory());

        connector.setPort(5432);
        server.addConnector(connector);

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(HelloServlet.class, "/");
        server.start();

    }
    public void stop() throws Exception{
        server.stop();
    }
}