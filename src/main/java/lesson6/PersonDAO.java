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
        // SQLLite will automatically create a database file, but the folder must exist
        String url = "jdbc:sqlite:src/main/java/lesson6/data/db.sqlite";
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

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public List<Person> findAllPersons() {
        List<Person> persons = new ArrayList<>();
        String query = "SELECT * FROM persons";

        // createStatement method can throw SQLException, so we'll catch that with a
        // try/catch block
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // We iterate the result rows until there is no longer the next row
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
    
                persons.add(new Person(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public int addPerson(Person person) {
        // ? symbols are variables for the database query
        String query = "INSERT INTO persons (name, age) VALUES (?, ?)";

        try {
            // We will use the PreparedStatement object, to use query variables and avoid
            // SQL injection
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Set a value for query variables in the specific index. This will replace the
            // ? in the database query
            preparedStatement.setString(1, person.getName()); // Index starts from 1!
            preparedStatement.setInt(2, person.getAge());

            // executeUpdate method is used to perform write operations (e.g. inserts or
            // updates)
            int rowCount = preparedStatement.executeUpdate();
            return rowCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Optional<Person> findPersonByName(String name) {
        String query = "SELECT * FROM persons WHERE name = ?";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, name);

            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                return Optional.of(new Person(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // No results rows for the query, so we'll return an empty optional
        return Optional.empty();
    }

    public void updatePerson(Person person) {
        String query = "UPDATE persons SET name = ?, age = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setInt(3, person.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(int id) {
        String query = "DELETE FROM persons WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllPersons() {
        String query = "DELETE FROM persons";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> findPersonsInAgeRange(int minAge, int maxAge) {
        // TODO: Find all persons whose age is above or equal to minAge and below or
        // equal to maxAge
        return List.of();
    }

    public void deletePersonByNameUNSAFE(String name) {
        // DANGER! We should ALWAYS use ? to assign query variables
        // This allows the user to exploit the SQL Injection attack
        // https://en.wikipedia.org/wiki/SQL_injection
        String sql = "DELETE FROM persons WHERE name = '" + name + "'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
