package lesson5.helpers;

/**
 * Records are like simple classes, with attributes and automatically
 * generated getter methods. The attributes of a record can't change (records
 * are "immutable"), so records don't have setter methods.
 * 
 * Further reading: https://www.baeldung.com/java-record-keyword
 */
public record Person(String name, int age) {
}
