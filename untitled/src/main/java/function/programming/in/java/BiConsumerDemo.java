package function.programming.in.java;

import java.util.function.BiConsumer;

public class BiConsumerDemo {

    public static void main(String[] args) {

        BiConsumer <Integer, Integer> addConsumer= (a,b) -> System.out.println(a+b);
        addConsumer.accept(10,30);
        BiConsumer <Integer,Integer> substractConsumer=(a, b) -> System.out.println(a-b);
        substractConsumer.accept(30,50);

        BiConsumer<Integer, Integer> combinedOperation = addConsumer.andThen(substractConsumer);

        combinedOperation.accept(50,30);

    }
}
