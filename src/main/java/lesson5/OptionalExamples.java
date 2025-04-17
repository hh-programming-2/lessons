package lesson5;

import java.util.List;
import java.util.Optional;

import lesson5.helpers.City;

/**
 * The purpose of this example is to demonstrate usage of the Optional object.
 */
public class OptionalExamples {
    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("Helsinki", 500_000),
                new City("Tampere", 200_000),
                new City("Pori", 70_000));

        City helsinki = findByName(cities, "Helsinki");
        System.out.println("Population of Helsinki: " + helsinki.getPopulation());

        City turku = findByName(cities, "Turku");
        // What's the problem here?
        System.out.println("Population of Turku: " + turku.getPopulation());

        // Optional object, either contains City object or is empty
        Optional<City> maybeTurku = maybeFindByName(cities, "Turku");

        // Optional communicates the possibility of a null (or "empty") value
        if (maybeTurku.isPresent()) {
            System.out.println("Population of Turku: " + maybeTurku.get().getPopulation());
        }

        int populationOfTurku = maybeTurku
                .map((city) -> city.getPopulation())
                .orElse(0);

        System.out.println("Population of Turku: " + populationOfTurku);
    }

    /*
     * First implementation: return a City object if found, otherwise return null
     */
    private static City findByName(List<City> cities, String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }

        // Danger zone!
        return null;
    }

    /*
     * Second implementation: return an Optional object
     */
    private static Optional<City> maybeFindByName(List<City> cities, String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                // Return Optional with a value
                return Optional.of(city);
            }
        }

        // Return empty Optional
        return Optional.empty();
    }
}
