package playground;

import java.io.IOException;
import java.sql.SQLException;

import org.h2.tools.Server;

// The web console of H2, started in this JVM: only from here can it see an in-memory database.
// It runs until Enter is pressed, then the program ends and the database is gone.
public final class H2Console {

    private H2Console() {
    }

    public static void openAndWait(String database) {
        try {
            Server web = Server.createWebServer("-webPort", "8082").start();
            System.out.println("H2 console: " + web.getURL() + " (open it in the browser)");
            System.out.println("JDBC URL:   jdbc:h2:mem:" + database + "   user: sa   password: (empty)");
            System.out.println("Press Enter to stop.");
            System.in.read();
            web.stop();
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Could not run the H2 console", e);
        }
    }
}
