package com.meiken;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import sun.net.www.http.HttpClient;

/**
 * @Author glf
 * @Date 2023/5/7
 */
public class JettyServer {
    public static void main(String[] args) throws Exception {

        ServletHandler servletHandler = new ServletHandler();

        Server server = new Server(8090);
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(MyServlet.class, "/*");
        server.start();

        server.join();

    }
}
