package function.programming.in.java;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class RealExamples {

    public static void main(String[] args) {
        BiFunction <String, Double, String> Books =(title, price) -> title + " Cost $"+ price;
        System.out.println(Books.apply("Code in Java", 599.43));
        System.out.println(Books.apply("Java with AI", 599.43));
        System.out.println(Books.apply("Java with REST API", 599.43));
        System.out.println(Books.apply("CCracking the coding interview in Java", 599.43));

        System.out.println("\n Using Consumer Formatter ");

        BiConsumer<String, Double> BooksCosting =(title, price) -> System.out.println(title + " Cost $"+ price);
        BooksCosting.accept("Code in Java", 599.43);
        BooksCosting.accept("Java with AI", 599.43);
        BooksCosting.accept("Java with REST API", 599.43);
        BooksCosting.accept("CCracking the coding interview in Java", 599.43);

        Predicate<Double> isExpensive = price -> price > 500;
        System.out.println(isExpensive.test(900.3));
        System.out.println(isExpensive.test(200.3));
;    }

}
