package lesson5;

/**
 * Records are like simple classes, with attributes and automatically
 * generated getter methods. The attributes of a record can't change (records
 * are "immutable"), so records don't have setter methods.
 * 
 * Further reading: https://www.baeldung.com/java-record-keyword
 */
public record Book(String title, String author, int pages) {
    // We can define methods for records as well
    public boolean isLongerThan(Book other) {
        return this.pages() > other.pages(); 
    }
}
