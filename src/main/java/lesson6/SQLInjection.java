package lesson6;

import lesson6.helpers.Country;

public class SQLInjection {
    public static void main(String[] args) {
        CountryDAO countryDAO = new CountryDAO();

        countryDAO.deleteAllCountries();

        countryDAO.addCountry(new Country("Finland", 5_600_000));
        countryDAO.addCountry(new Country("Sweden", 10_500_000));
        countryDAO.addCountry(new Country("Norway", 5_500_000));

        System.out.println("All countries:");
        countryDAO.findAllCountries().forEach(System.out::println);

        /*
         * SQL Injection (https://en.wikipedia.org/wiki/SQL_injection):
         * "SQL injection is a code injection technique used to attack data-driven
         * applications, in which malicious SQL statements are inserted into an entry
         * field for execution"
         */
        String maliciousUserInput = "Sweden";
        // Let's assume that the maliciousUserInput can be determined by the user
        // What if maliciousUserInput would have value of "Finland' OR '1' = '1" ?
        countryDAO.deleteCountryByNameUNSAFE(maliciousUserInput);

        System.out.println("All countries after the malicious operation:");
        countryDAO.findAllCountries().forEach(System.out::println);
    }
}
