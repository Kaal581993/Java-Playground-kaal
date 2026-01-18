package intermediate.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsChallengeDemo {
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

        //Challenge 1: Total Cost of all the Books in the Books Store
        double totalCost = books.stream()
                        .mapToDouble(book -> book.price)
                        .reduce(0, Double :: sum);
        System.out.println("\nTotal Cost of Books=\n"+totalCost);

        //Challenge 2: Collecting books in List of Titles
        List<String> TitlesCollections = books.stream()
                .map(book -> book.title)
                        .collect(Collectors.toList());
        System.out.println("\n The list of Book Titles are as follows:\n"+TitlesCollections);

        //Challenge 3: Grouping books in Categories

         Function<Book, String> bookStringFunction = new Function<Book, String>(){
            @Override
            public String apply(Book book){
                return book.getCategory();
            }
        };

        System.out.println("\nList of Book Categories\n");
        Map <String, List<Book>> bookCategories=books.stream().collect(Collectors.groupingBy(bookStringFunction));
        bookCategories.forEach((category, bookList)->{
            bookList.forEach(System.out::println);
        });
        System.out.println("\n The list of Book Categories are as follows:\n"+bookCategories);

        System.out.println("\nList of Book Categoriesusing reference\n");
        Map <String, List<Book>> bookCategories2=books.stream().collect(Collectors.groupingBy(Book::getCategory));
        bookCategories.forEach((category, bookList)->{
            bookList.forEach(System.out::println);
        });
        System.out.println("\n The list of Book Categories are as follows:\n"+bookCategories2);

    }
}
