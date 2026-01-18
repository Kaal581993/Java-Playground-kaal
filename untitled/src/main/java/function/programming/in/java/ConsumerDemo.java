package function.programming.in.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args){
        Consumer<String> consumer1= (str)->System.out.println(str);
        Consumer<String> consumer2= System.out::println;

        Consumer<String> consumer3=(str)->System.out.println("Length:"+str.length());

        consumer1.accept("Hello Kaal");
        consumer2.accept("The Matrix has you!");
        consumer3.accept("Follow the white Rabbit");


        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        Consumer<Integer> multiplyBy2 = n-> System.out.println(n+" x 2 is:"+n*2);
        numbers.forEach(multiplyBy2);


    }
}
