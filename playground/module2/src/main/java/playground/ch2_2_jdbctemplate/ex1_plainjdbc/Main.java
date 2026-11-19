package playground.ch2_2_jdbctemplate.ex1_plainjdbc;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Plain JDBC, no JdbcTemplate: one row by its id.
public class Main {

    public static void main(String[] args) {
        EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("robots-schema.sql").addScript("robots-data.sql").build();
        System.out.println(findById(dataSource, 1));
        dataSource.shutdown();
    }

    static Robot findById(EmbeddedDatabase dataSource, int id) {
        String sql = "SELECT id, name, speed FROM robot WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }
                return new Robot(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("speed"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not read robot " + id, e);
        }
    }
}
