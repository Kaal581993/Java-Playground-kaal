package intermediate.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateDemo {
    public static void main(String[] args) {
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
       new Book("Algorithms", 2011, 65.00, "Computer Science")
        );

        System.out.println("Books costs Lower than 50$: \n");
        //1. Filtering: Books cheaper than $30
        Stream<Book> stream1 = books.stream();
        stream1.filter(b-> b.price <50).forEach(System.out::println);
        //2. Mapping: Converting Books title to Uppercase
        System.out.println("\n Titles in Uppercase:\n");
        Stream<String> upperCaseTitles = books.stream().map(book -> book.title.toUpperCase());
        upperCaseTitles.forEach(System.out::println);


        //3. Sorting:  Books by Publication date
        System.out.println("\nSorting books by Publication Dates\n");

        Stream<Book> sortByDates = books.stream().sorted(Comparator.comparingInt(book -> book.publicationYear));
        sortByDates.forEach(System.out::println);
        //4. Distinct: Remove Duplicate Titles

        System.out.println("\nRemoved Duplicates:\n");
        Stream<Book> removeDupliccates = books.stream().distinct();
        removeDupliccates.forEach(System.out::println);
        //5. Limit: Display only first 3 books
        System.out.println("\nThe first 3 booksTitles:\n");
        Stream<Book> firstThreeTitles = books.stream().limit(3);
        firstThreeTitles.forEach(System.out::println);

        //6. Skip: Skip the first 2 books
        System.out.println("\nSkip the first 2 booksTitles:\n");
        Stream<Book> skipFirstTwo = books.stream().skip(2);
        skipFirstTwo.forEach(System.out::println);

        //7. The first 3 booksTitles by Publication year
        System.out.println("\nThe first 3 booksTitles by Publication year:\n");
        Stream<Book> firstThreeTitlesbyYear = books.stream().sorted(Comparator.comparingInt(book -> book.publicationYear)).limit(3);
        firstThreeTitlesbyYear.forEach(System.out::println);

    }
}
