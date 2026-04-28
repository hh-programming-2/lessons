package lesson6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lesson6.helpers.Country;

/**
 * This DAO class handles country related database operations. The data is
 * presented as Country objects.
 */
public class CountryDAO {
    private Connection connection;

    public CountryDAO() {
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
                CREATE TABLE IF NOT EXISTS countries (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL UNIQUE,
                    population INTEGER NOT NULL
                )
                """;

        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Country> findAllCountries() {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM countries";

        // createStatement method can throw SQLException, so we'll catch that with a
        // try/catch block
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // We iterate the result rows until there is no longer the next row
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int population = resultSet.getInt("population");

                countries.add(new Country(id, name, population));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public int addCountry(Country country) {
        // ? symbols are variables for the database query
        String query = "INSERT INTO countries (name, population) VALUES (?, ?)";

        try {
            // We will use the PreparedStatement object, to use query variables and avoid
            // SQL injection
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Set a value for query variables in the specific index. This will replace the
            // ? in the database query
            preparedStatement.setString(1, country.getName()); // Index starts from 1!
            preparedStatement.setInt(2, country.getPopulation());

            // executeUpdate method is used to perform write operations (e.g. inserts or
            // updates)
            int rowCount = preparedStatement.executeUpdate();
            return rowCount;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Optional<Country> findCountryByName(String name) {
        String query = "SELECT * FROM countries WHERE name = ?";

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, name);

            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int population = resultSet.getInt("population");

                return Optional.of(new Country(id, name, population));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // No results rows for the query, so we'll return an empty optional
        return Optional.empty();
    }

    public void updateCountry(Country country) {
        String query = "UPDATE countries SET name = ?, population = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getPopulation());
            preparedStatement.setInt(3, country.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCountry(int id) {
        String query = "DELETE FROM countries WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllCountries() {
        String query = "DELETE FROM countries";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Country> findCountriesInPopulationRange(int minPopulation, int maxPopulation) {
        // TODO: Find countries that have population larger or equal to minPopulation,
        // and less than or equal to maxPopulation
        return List.of();
    }

    public void deleteCountryByNameUNSAFE(String name) {
        // DANGER! We should ALWAYS use ? to assign query variables
        // This allows the user to exploit the SQL Injection attack
        // https://en.wikipedia.org/wiki/SQL_injection
        String sql = "DELETE FROM countries WHERE name = '" + name + "'";

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