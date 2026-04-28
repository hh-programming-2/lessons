package lesson6.helpers;

public class Country {
    private int id;
    private String name;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public Country(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}