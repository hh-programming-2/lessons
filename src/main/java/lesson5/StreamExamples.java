package lesson5;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {
        List<String> toppings = List.of("Ham", "Pineapple", "Pepperoni", "Olive");

        List<Book> books = List.of(
                new Book("The Hobbit", "J.R.R. Tolkien", 310),
                new Book("The Two Towers", "J.R.R. Tolkien", 352),
                new Book("Dune", "Frank Herbert", 412),
                new Book("Klara and the Sun", "Kazuo Ishiguro", 303),
                new Book("Foundation", "Isaac Asimov", 255));

        // Example 1:
        List<Integer> lengths = getLengthsOfStrings(toppings);
        System.out.println("Lengths of strings: " + lengths);

        // Example 2:
        // - Ham
        // - Pineapple
        // - ...
        String toppingsList = createMarkdownList(toppings);
        System.out.println("Toppings list:");
        System.out.println(toppingsList);

        // Example 3:
        Optional<Book> maybeBook = findByTitle(books, "Dune");
        maybeBook.ifPresent(book -> System.out.println("Found this book: " + book));

        // Example 4:
        double averagePages = getAveragePagesByAuthor(books, "J.R.R. Tolkien");
        System.out.println("Average pages in books by J.R.R. Tolkien: " + averagePages);

        // Example 5:
        List<Book> sortedBooks = getSortedBooks(books);
        System.out.println("Books sorted by page count: " + sortedBooks);
    }

    // Example 1: Usage of streams and lambdas to get the lengths of strings
    public static List<Integer> getLengthsOfStrings(List<String> strings) {
        return strings.stream()
                // Or .map(String::length) in short
                .map(value -> value.length())
                // Collect the results using the Collectors.toList method
                // Same as .toList()
                .collect(Collectors.toList());
    }

    // Example 2: Using reduce collector to combine list of strings
    public static String createMarkdownList(List<String> items) {
        return items.stream()
                .map(item -> "- " + item + "\n")
                // The reduce operation combines all elements into a single string by starting
                // with an empty string ("") and appending each element (current) to the
                // accumulated result (combined)
                .reduce("", (combined, current) -> combined + current);
    }

    // Example 3: Find a book by title. It may not be found, so the result is an
    // Optional<Book>.
    public static Optional<Book> findByTitle(List<Book> books, String title) {
        /*
         * for (Book book : books) {
         *     if (book.title().equals(title)) {
         *         return Optional.of(book); // Found the book, wrap it into an Optional
         *     }
         * }
         * // Not found, return an empty Optional
         * return Optional.empty();
         */

        return books.stream()
                .filter(book -> book.title().equals(title))
                // findFirst collector returns an Optional with the first element in the stream, if any
                .findFirst();
    }

    // Example 4: Using streams and lambdas to calculate the average page count
    // above a threshold
    public static double getAveragePagesByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(book -> book.author().equals(author))
                // We need to map the stream values to double to use the average collector
                .mapToDouble(book -> book.pages())
                // average method returns a OptionalDouble object
                .average()
                // If the optional doesn't have a value, default to 0
                .orElse(0);
    }

    // Example 5: Sorting a stream
    private static List<Book> getSortedBooks(List<Book> books) {
        return books.stream()
                // Sort by pages:
                .sorted((bookA, bookB) -> Integer.compare(bookA.pages(), bookB.pages()))
                // Sort by title: 
                // .sorted((bookA, bookB) -> bookA.title().compareTo(bookB.title()))
                .toList();
    }

}
