package lesson5;

import java.util.List;
import java.util.Optional;

/**
 * The purpose of this example is to demonstrate usage of the Optional object.
 */
public class OptionalExamples {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("The Hobbit", "J.R.R. Tolkien", 310),
                new Book("Dune", "Frank Herbert", 412),
                new Book("Foundation", "Isaac Asimov", 255));

        Book theHobbit = findByTitle(books, "The Hobbit");
        System.out.println("Author of The Hobbit: " + theHobbit.author());

        Book eastOfEden = findByTitle(books, "East of eden");
        // What's the problem here? The method can return null, which must be checked before use.
        // System.out.println("Author of East of eden: " + eastOfEden.author());

        // Optional object, either contains a Book object or is empty
        Optional<Book> maybeBook = maybeFindByTitle(books, "East of eden");

        // Optional communicates the possibility of a null (or "empty") value
        if (maybeBook.isPresent()) {
            System.out.println("Pages in the book: " + maybeBook.get().pages());
        }

        int pagesOfBook = maybeBook
                .map(book -> book.pages())
                .orElse(0);

        System.out.println("Pages in the book: " + pagesOfBook);
    }

    /*
     * First implementation: return a Book if found, otherwise return null
     */
    private static Book findByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title().equals(title)) {
                return book;
            }
        }

        // Danger zone!
        return null;
    }

    /*
     * Second implementation: return an Optional object
     */
    private static Optional<Book> maybeFindByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title().equals(title)) {
                // Return Optional with a value
                return Optional.of(book);
            }
        }

        // Return empty Optional
        return Optional.empty();
    }
}
