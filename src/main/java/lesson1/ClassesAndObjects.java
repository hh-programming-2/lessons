package lesson1;

public class ClassesAndObjects {
    public static void main(String[] args) {
        Player mcdavid = new Player("Connor McDavid", 12, 7);
        Player laine = new Player("Patrik Laine", 18, 4);

        System.out.println(mcdavid.getName() + ": " + mcdavid.getGoals() + " + "
                + mcdavid.getAssists() + " = " + mcdavid.getPoints());

        System.out.println(laine.getName() + ": " + laine.getGoals() + " + "
                + laine.getAssists() + " = " + laine.getPoints());

        laine.setGoals(20);
        laine.setAssists(5);

        System.out.println(laine.getName() + ": " + laine.getGoals() + " + "
                + laine.getAssists() + " = " + laine.getPoints());
    }
}
