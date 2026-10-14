package lesson5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 1. Using a stream and lambda function to filter out odd numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                // Stream must be "collected", in order it to be "executed", that is evaluated
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);

        // Example 2. Using a stream and labmda function to transform each number into
        // its square
        List<Integer> squaresOfNumbers = numbers.stream()
                .map(n -> n * n)
                .toList(); // same as collect(Collectors.toList())

        System.out.println("Squares of numbers: " + squaresOfNumbers);

        List<Book> books = List.of(
                new Book("The Hobbit", "J.R.R. Tolkien", 310),
                new Book("Dune", "Frank Herbert", 412),
                new Book("War and Peace", "Leo Tolstoy", 1225),
                new Book("War of the Worlds", "H.G. Wells", 287),
                new Book("Foundation", "Isaac Asimov", 255));

        // Example 3. Using multiple stream operations
        // to get titles of books with fewer than 500 pages
        List<String> shortBookTitles = books.stream()
                .filter(book -> book.pages() < 500)
                .map(book -> book.title())
                .toList();

        System.out.println("Book titles with fewer than 500 pages: " + shortBookTitles);

        // Example 4: Reusing streams
        // TODO: Create a stream of long books to reuse it
        // TODO: Get a list of long book titles
        List<String> longBookTitles = List.of();

        // TODO: Get list of long book pages
        List<Integer> longBookPageCounts = List.of();

        System.out.println("Titles of books with more than 300 pages: " + longBookTitles);
        System.out.println("Page counts of books with more than 300 pages: " + longBookPageCounts);

        // Example 5. Collecting streams
        long booksCount = books.stream()
                .filter(book -> book.title().startsWith("War"))
                // count collects the number of items in the stream
                .count();

        int totalPages = books.stream()
                // We need to map the stream values to int or double to collect the sum
                .mapToInt(book -> book.pages())
                // sum collects the sum of values in the stream
                .sum();

        int largestNumber = numbers.stream()
                // max collects the maximum value in the stream using a comparator
                .max((numA, numB) -> Integer.compare(numA, numB))
                // It is possible that the stream does not return anything, so the result is of
                // Optional type
                .orElse(0);

        System.out.println("Book titles starting with word 'War': " + booksCount);
        System.out.println("Total pages: " + totalPages);
        System.out.println("Largest number: " + largestNumber);

        // Example 6. Comparison of for loop ja stream implementations
        System.out.println("Pages in books over 300 pages using for loop = " + sumBookPagesUsingForLoop(books));
        System.out.println("Pages in books over 300 pages using stream = " + sumBookPagesUsingStream(books));
    }

    private static int sumBookPagesUsingForLoop(List<Book> books) {
        int sum = 0;
        for (Book book : books) {
            if (book.pages() > 300) {
                sum += book.pages();
            }
        }
        return sum;
    }

    private static int sumBookPagesUsingStream(List<Book> books) {
        // The types of the lambda functions are displayed below
        // (https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html)
        // Predicate<Book> isLongBook = book -> book.pages() > 300;
        // ToIntFunction<Book> toPageCount = Book::pages;
        return books.stream()
                .filter(book -> book.pages() > 300)
                // This is a method reference, same as lambda book -> book.pages()
                .mapToInt(Book::pages)
                .sum();
    }

    private static Stream<Book> getLongBookStream(List<Book> books) {
        // TODO: return stream of Book objects with more than 300 pages
        return null;
    }
}
