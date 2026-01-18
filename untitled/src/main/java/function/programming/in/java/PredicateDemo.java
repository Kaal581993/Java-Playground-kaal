package function.programming.in.java;

import java.util.function.BiPredicate;
import java.util.function.Predicate;


public class PredicateDemo {
    public static void main(String[] args) {
        Predicate <Integer> isEven = n ->n % 2 == 0;
        System.out.println(isEven.test(33));
        System.out.println(isEven.test(26));

        BiPredicate<Integer, Integer> isSumOdd = (x, y) -> (x+y) % 2 !=0;

        System.out.println(isSumOdd.test(45,64));
    }
}
