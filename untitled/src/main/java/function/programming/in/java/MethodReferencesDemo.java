package function.programming.in.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class MethodReferencesDemo {

    public static void main(String[] args){
        List <String> names = Arrays.asList("Charlie","Bob","David","Ronaldo","Beckham");
        for (int i=0;i<names.size();i++){
            System.out.println(names.get(i));
        }

        //Using enhanced For each: Works only with collection framework

        System.out.println("\nUsing For each Loop ");
        for (String name:names){
            System.out.println(name);
        }

        System.out.println("\nUsing For each Functional Interface ");

        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });

        System.out.println("\nUsing For each Functional Interface with Lambda");

        names.forEach((String name) -> {
                System.out.println(name);

        });

        System.out.println("\nUsing For each Functional Interface with Lambda and infered data type");

        names.forEach((name) -> {
            System.out.println(name);

        });

        names.forEach((name) ->System.out.println(name));

        System.out.println("\nUsing For each Functional Interface with method reference");

        names.forEach(System.out::println);

    }
}
