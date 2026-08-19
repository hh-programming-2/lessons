package lesson1;

// Example of a class representing a hockey player
public class Player {
    // Attributes are properties, which objects of a class has
    private String name;
    private int goals;
    private int assists;

    // A constructor initializes an object of a class
    public Player(String name, int goals, int assists) {
        this.name = name;
        this.goals = goals;
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    // Methods specify functionality of the class, e.g. getting information from object's attributes
    public int getPoints() {
        return goals + assists;
    }
}
