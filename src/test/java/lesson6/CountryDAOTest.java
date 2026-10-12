package lesson6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lesson6.helpers.Country;

class CountryDAOTest {
    @Test
    void findsCountriesWithinInclusivePopulationRange() {
        CountryDAO countryDAO = new CountryDAO();
        try {
            countryDAO.deleteAllCountries();
            countryDAO.addCountry(new Country("Range lower", 100));
            countryDAO.addCountry(new Country("Range middle", 150));
            countryDAO.addCountry(new Country("Range upper", 200));
            countryDAO.addCountry(new Country("Range below", 99));
            countryDAO.addCountry(new Country("Range above", 201));

            Set<String> countryNames = countryDAO.findCountriesInPopulationRange(100, 200).stream()
                    .map(Country::getName)
                    .collect(Collectors.toSet());

            assertEquals(Set.of("Range lower", "Range middle", "Range upper"), countryNames);
        } finally {
            countryDAO.deleteAllCountries();
            countryDAO.close();
        }
    }
}
