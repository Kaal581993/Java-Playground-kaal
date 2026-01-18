package function.programming.in.java;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.BiConsumer;

public class BiFunctionDemo {

    public static BiFunction<Integer, Integer, Integer> addFunction = (a, b) -> a + b;

    public static BiFunction<Integer, Integer, Integer>
            addFunction2 =Integer::sum;

    public static BiFunction<Integer, Integer, Integer> substractFunction = (a, b) -> a - b;

//    public static BiFunction<Integer, Integer, Integer> substractFunction2
//            = Integer::


    public static void main(String[] args){

        System.out.println(addFunction.apply(10,20));

        System.out.println(addFunction2.apply(10,20));

        System.out.println("\nUsing Substraction Method");
        System.out.println(substractFunction.apply(80,20));

        Function <Integer, Integer> multiplyBy2  = x -> x * 2;

        BiConsumer <Integer, Integer> addConsumer= (a,b) -> System.out.println("Addition using BiConsumer"+a+b);

        BiFunction <Integer, Integer, Integer> combinedFunction= addFunction.andThen(multiplyBy2);

        System.out.println("\nUsing Combined Function");
        System.out.println(combinedFunction.apply(5,9));


    }
}
