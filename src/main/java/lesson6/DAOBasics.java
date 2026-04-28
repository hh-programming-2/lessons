package lesson6;

import java.util.List;

import lesson6.helpers.Country;

/**
 * This example demonstrate the usage of the Data Access Object (DAO) pattern.
 * The purpose of the DAO pattern is to provide an abstract interface to some
 * type of database or other persistence mechanism.
 */
public class DAOBasics {
    public static void main(String[] args) {
        // Initialize CountryDAO object
        CountryDAO countryDAO = new CountryDAO();

        // Clear the database table by deleting all countries
        countryDAO.deleteAllCountries();

        // Add countries to the database
        countryDAO.addCountry(new Country("Finland", 5_600_000));
        countryDAO.addCountry(new Country("Sweden", 10_500_000));
        countryDAO.addCountry(new Country("Norway", 5_500_000));

        // Find all countries in the database and print them
        System.out.println("All countries:");
        countryDAO.findAllCountries().forEach(System.out::println);

        // Find all countries with population in range 5,000,000-11,000,000
        List<Country> countriesInRange = countryDAO.findCountriesInPopulationRange(5_000_000, 11_000_000);
        System.out.println("Countries in population range 5,000,000-11,000,000:");
        System.out.println(countriesInRange);

        // Update country information in the database
        Country countryToUpdate = countryDAO.findCountryByName("Finland").orElse(null);

        if (countryToUpdate != null) {
            countryToUpdate.setPopulation(5_650_000);
            countryDAO.updateCountry(countryToUpdate);
            System.out.println("Country has been updated");
        }

        // Find all countries again after the update and print them
        System.out.println("All countries after the update:");
        countryDAO.findAllCountries().forEach(System.out::println);

        // Delete country from the database
        Country countryToDelete = countryDAO.findCountryByName("Sweden").orElse(null);

        if (countryToDelete != null) {
            countryDAO.deleteCountry(countryToDelete.getId());
            System.out.println("Country has been deleted");
        }

        // Find all countries again after the delete and print them
        System.out.println("All countries after the delete:");
        countryDAO.findAllCountries().forEach(System.out::println);

        // Finally, close the database connection
        countryDAO.close();
    }
}
