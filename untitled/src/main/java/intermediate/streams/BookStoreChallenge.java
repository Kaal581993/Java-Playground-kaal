package intermediate.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class BookStoreChallenge {
    public static void main(String[] args) {
        /**
         * Disccounted Books: The Books store is planning to sale books, Identify the Books
         * that is having price greater than 50$. Display these books
         * Classic Collection:The Book store is launcting a classic collection, identify and Display the books that were published before year 2000
         * Upcoming titles:  Generate the List of titles for the Future Books for the next year coming soon suffix titles
         * Sort by Price: Sort by price in Ascending order.
         * Rare Boooks: a Book having titles more than 20 characters are considered to be rare books
         *
         *
         */

        List<Book> books = Arrays.asList(

                new Book("Effective Java", 2018, 45.99, "Programming"),
                new Book("Clean Code", 2008, 40.50, "Programming"),
                new Book("Java Concurrency in Practice", 2006, 55.00, "Programming"),
                new Book("Design Patterns", 1994, 60.00, "Programming"),
                new Book("Spring in Action", 2022, 50.75, "Framework"),
                new Book("Hibernate in Action", 2016, 42.30, "ORM"),
                new Book("Head First Java", 2005, 35.99, "Beginner"),
                new Book("Microservices Patterns", 2019, 58.20, "Architecture"),
                new Book("Refactoring", 2018, 47.80, "Programming"),
                new Book("Algorithms", 2011, 65.00, "Computer Science"),
                new Book("Cracking the coding interview with Java Programming",1984,98.56,"Interview Prep")
        );


                 /**
                  * Problem Set 1:
                  * Disccounted Books: The Books store is planning to sale books, Identify the Books
                  * that is having price greater than 50$. Display these books
                  *
                  */
        System.out.println("\nFollowing books have 10% added discount\n");
        Stream <Book> DisountedBooks= books.stream();
        DisountedBooks.filter(book -> book.price>50).forEach(System.out::println);

        /**
         * Problem Set 2:
         * Classic Collection:The Book store is launcting a classic collection,
         * identify and Display the books that were published before year 2000
         * */

        System.out.println("\nFollowing books are classic edition books\n");

        Stream <Book> classicBooks = books.stream().filter(book -> book.publicationYear<2000);
        classicBooks.forEach(System.out::println);
        /**
         * Problem Set 3:
         * Upcoming titles:  Generate the List of titles for the Future Books for the next year coming soon suffix titles
         *
         * */

        System.out.println("\n the List of titles for the Future Books for the next year coming soon suffix titles \n");
        books.stream().map(book -> book.title+"(Coming Soon)").forEach(System.out::println);
        /**
         * Problem Set 4:
         * Sort by Price: Sort by price in Ascending order.
         *
         * */
        System.out.println("\nBooks Sorted in Ascending order with respect to price\n");

        Stream <Book> sortedByPrice=books.stream().sorted(Comparator.comparingDouble(book -> book.price));
        sortedByPrice.forEach(System.out::println);

        /**
         * Problem Set 5:
         *
         * Rare Boooks: a Book having titles more than 20 characters are considered to be rare books
         * */
        System.out.println("\nBooks having category of Rare collection\n");
        Stream<Book> rareBook = books.stream().filter(book -> book.title.length()>20);
        rareBook.forEach(System.out::println);

    }
}
