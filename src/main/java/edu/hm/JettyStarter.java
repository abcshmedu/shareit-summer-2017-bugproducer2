package edu.hm;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Start the application without an AppServer like tomcat.
 *
 * @author <a mailto:axel.boettcher@hm.edu>Axel B&ouml;ttcher</a>
 */
public class JettyStarter {

    public static final String APP_URL = "/";
    public static final int PORT = 8080;
    public static final String WEBAPP_DIR = "./src/main/webapp/";

    private static Server jetty;

    /**
     * Deploy local directories using Jetty without needing a container-based deployment.
     *
     * @throws Exception might throw for several reasons.
     */
    public  void startJetty() throws Exception {
        jetty = new Server(PORT);
        jetty.setHandler(new WebAppContext(WEBAPP_DIR, APP_URL));
        jetty.start();
        System.out.println("Jetty listening on port " + PORT);
        //jetty.join();
    }

    public void stopJetty() throws Exception {
        jetty.stop();
    }

}
