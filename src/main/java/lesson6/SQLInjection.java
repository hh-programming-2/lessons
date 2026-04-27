package lesson6;

import lesson6.helpers.Person;

public class SQLInjection {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        personDAO.deleteAllPersons();

        personDAO.addPerson(new Person("Maija", 25));
        personDAO.addPerson(new Person("Pekka", 45));
        personDAO.addPerson(new Person("Kalle", 33));

        System.out.println("All persons:");
        personDAO.findAllPersons().forEach(System.out::println);

        /*
         * SQL Injection (https://en.wikipedia.org/wiki/SQL_injection):
         * "SQL injection is a code injection technique used to attack data-driven
         * applications, in which malicious SQL statements are inserted into an entry
         * field for execution"
         */
        String maliciousUserInput = "Pekka";
        // Let's assume that the maliciousUserInput can be determined by the user
        // What if maliciousUserInput would have value of "Maija' OR '1' = '1" ?
        personDAO.deletePersonByNameUNSAFE(maliciousUserInput);

        System.out.println("All persons after the malicious operation:");
        personDAO.findAllPersons().forEach(System.out::println);
    }
}
