package playground.ch2_2_jdbctemplate.ex1b_h2console;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import playground.H2Console;

// The database of ex1_plainjdbc, with a fixed name, and H2's web console to look into it.
// Any other example works the same: give its database a name and call H2Console.openAndWait at the end of main.
public class Main {

    public static void main(String[] args) {
        EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .setName("robots")   // a fixed name, so the console can find the database
                .addScript("robots-schema.sql").addScript("robots-data.sql").build();
        H2Console.openAndWait("robots");   // playground.H2Console: starts H2's web console, waits for Enter
        dataSource.shutdown();
    }
}
