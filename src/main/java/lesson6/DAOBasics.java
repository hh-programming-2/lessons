package lesson6;

import java.util.List;

import lesson6.helpers.Person;

/** 
 * This example demonstrate the usage of the Data Access Object (DAO) pattern.
 * The purpose of the DAO pattern is to provide an abstract interface to some type of database or other persistence mechanism.
 * 
 * For this example, remember to include the SQLLite-driver to the build.grade file and "Refresh gradle project" (eclipse)
 */
public class DAOBasics {
    public static void main(String[] args) {
        // Initialize PersonDAO object
        PersonDAO personDAO = new PersonDAO();

        // Clear the database table by deleting all persons
        personDAO.deleteAllPersons();

        // Add persons to the database
        personDAO.addPerson(new Person("Maija", 25));
        personDAO.addPerson(new Person("Pekka", 45));
        personDAO.addPerson(new Person("Kalle", 33));

        // Find all persons in the database and print them
        System.out.println("All persons:");
        personDAO.findAllPersons().forEach(System.out::println);

        // Find all persons in age range 30-50
        List<Person> oldPersons = personDAO.findPersonsInAgeRange(30, 50);
        System.out.println("Persons in age range 30-50:");
        System.out.println(oldPersons);

        // Update person information in the database
        Person personToUpdate = personDAO.findPersonByName("Maija").orElse(null);
        
        if (personToUpdate != null) {
            personToUpdate.setAge(26);
            personDAO.updatePerson(personToUpdate);
            System.out.println("Person has been updated");
        }

        // Find all persons again after the update and print them
        System.out.println("All persons after the update:");
        personDAO.findAllPersons().forEach(System.out::println);

        // Delete person from the database
        Person personToDelete = personDAO.findPersonByName("Pekka").orElse(null);

        if (personToDelete != null) {
            personDAO.deletePerson(personToDelete.getId());
            System.out.println("Person has been deleted");
        }

        // Find all persons again after the delete and print them
        System.out.println("All persons after the delete:");
        personDAO.findAllPersons().forEach(System.out::println);
        
        // Finally, close the database connection
        personDAO.close();
    }
}
