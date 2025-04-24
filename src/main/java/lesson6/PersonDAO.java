package lesson6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lesson6.helpers.Person;

/**
 * This DAO class for person related database operations. The data is presented
 * as Person objects.
 */
public class PersonDAO {
    private Connection connection;

    public PersonDAO() {
        // In the constructor we establish database connection and initialize the
        // database table
        try {
            connection = getConnection();
            createTable(); // Create the database table if it doesn't already exist
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        // Define the connection string for the database
        String url = "jdbc:sqlite:src/main/java/lesson6/data/db.sqlite"; // SQLLite will automatically create a database
                                                                         // file, but the folder must exist
        // String mySQLUrl =
        // "jdbc:mysql://localhost:3306/my_database?user=myUser&password=myPassword";

        return DriverManager.getConnection(url);
    }

    private void createTable() throws SQLException {
        String query = """
                CREATE TABLE IF NOT EXISTS persons (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL UNIQUE,
                    age INTEGER NOT NULL
                )
                """;
        
        /*
         * String mySQLQuery = """
         * CREATE TABLE IF NOT EXISTS persons (
         *     id INT  PRIMARY KEY AUTO_INCREMENT,
         *     name VARCHAR(255) NOT NULL,
         *     age INT NOT NULL
         * )
         * """;
         */

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public int addPerson(Person person) {
        // ? symbols are variables for the database query
        String query = "INSERT INTO persons (name, age) VALUES (?, ?)";

        // We will use the PreparedStatement object, which avoids SQL injections
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set a value for query variables in the specific index. This will replace the
            // ? in the database query
            preparedStatement.setString(1, person.getName()); // Index starts from 1!
            preparedStatement.setInt(2, person.getAge());
            int rowCount = preparedStatement.executeUpdate();
            return rowCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Person> findAllPersons() {
        List<Person> persons = new ArrayList<>();
        String query = "SELECT * FROM persons";

        try (Statement lause = connection.createStatement();
                ResultSet tulokset = lause.executeQuery(query)) {
            while (tulokset.next()) {
                int id = tulokset.getInt("id");
                String name = tulokset.getString("name");
                int age = tulokset.getInt("age");
                persons.add(new Person(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    // Find person by name
    public Optional<Person> findPersonByName(String name) {
        String query = "SELECT * FROM persons WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int age = resultSet.getInt("age");
                    return Optional.of(new Person(id, name, age));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updatePerson(Person person) {
        String sql = "UPDATE persons SET name = ?, age = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setInt(3, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(int id) {
        String sql = "DELETE FROM persons WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllPersons() {
        String sql = "DELETE FROM persons";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // We should close the database connection once we don't intend to perform any
    // more queries
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
