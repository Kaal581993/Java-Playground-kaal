package streams.pracctice.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstStreamDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
//Iteration 1 witout using Streams
        List <Integer> evenNumbers1 = new ArrayList<>();
        for (int num: numbers){
            if (num %2 == 0){
                evenNumbers1.add(num);
            }
        }
        System.out.println("Even Numbers without stream"+evenNumbers1);

    //Iteration 2 using streams

        Stream <Integer> integerStream1= numbers.stream();
        Stream <Integer> integerStream2= integerStream1.filter(p3);
        List<Integer> evenNumbers2=integerStream2.toList();
        System.out.println("Even Numbers using  Streams"+evenNumbers2);


//        Stream <Integer> integerStream3= integerStream2.filter(p2);
//        List<Integer> evenNumbers3=integerStream3.toList();
//        System.out.println("Even Numbers using Lambda Streams"+evenNumbers3);
//
//        Stream <Integer> integerStream4= integerStream3.filter(p3);
//        List<Integer> evenNumbers4=integerStream4.toList();
//        System.out.println("Even Numbers using concise Lambda Streams"+evenNumbers4);

        //Iteration 3

        List<Integer> evenNumbers3=numbers.stream().filter(num -> num %2 == 0).toList();
        System.out.println("Even Numbers using single line Streams without creating object"+evenNumbers3);
    }

    static Predicate<Integer> p= new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {

           int remainder= integer % 2;
                if (remainder == 0)
                    return true;
            return false;
        }
    };

    //Using Lambda
    static Predicate<Integer> p2= ( integer) ->{

            int remainder= integer % 2;
            if (remainder == 0)
                return true;
            return false;

    };

    //Using one line concise lambda
    static Predicate<Integer> p3= ( integer) ->integer % 2==0;


}
