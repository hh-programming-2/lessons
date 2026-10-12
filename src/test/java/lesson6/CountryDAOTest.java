package lesson6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lesson6.helpers.Country;

class CountryDAOTest {
    @Test
    void findsCountriesWithinInclusivePopulationRange() {
        CountryDAO countryDAO = new CountryDAO();
        String testId = UUID.randomUUID().toString();
        List<Country> testCountries = List.of(
                new Country("Range lower " + testId, 100),
                new Country("Range middle " + testId, 150),
                new Country("Range upper " + testId, 200),
                new Country("Range below " + testId, 99),
                new Country("Range above " + testId, 201));
        try {
            testCountries.forEach(countryDAO::addCountry);

            Set<String> countryNames = countryDAO.findCountriesInPopulationRange(100, 200).stream()
                    .map(Country::getName)
                    .collect(Collectors.toSet());

            assertEquals(Set.of(
                    "Range lower " + testId,
                    "Range middle " + testId,
                    "Range upper " + testId), countryNames);
        } finally {
            testCountries.forEach(country -> countryDAO.findCountryByName(country.getName())
                    .ifPresent(found -> countryDAO.deleteCountry(found.getId())));
            countryDAO.close();
        }
    }
}
