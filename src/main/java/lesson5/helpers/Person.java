package lesson5.helpers;

/**
 * Records are like simple classes, with just attributes and automatically
 * generated getter methods. The attributes of a record can't change, so records
 * are "immutable".
 */
public record Person(String name, int age) {
}
