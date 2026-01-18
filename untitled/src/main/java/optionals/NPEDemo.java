package optionals;

import java.util.Optional;

public class NPEDemo {
    public static void main(String[] args) {
        String name=null;
        if(name !=null)
            System.out.println(name.length());
        else
            System.out.println("Name is not initialized");

        //Creating Optionals
        Optional<String> optionalStringDemo = Optional.of("Java");
        //Null value in Optional.of will throw an Exception
        System.out.println(optionalStringDemo);

        Optional<String> emptyString = Optional.empty();
        System.out.println(emptyString);

        Optional<String> maybe = Optional.ofNullable(null);
        System.out.println(maybe);

        //Checking values
        System.out.println(optionalStringDemo.isPresent());
        System.out.println(optionalStringDemo.isEmpty());
        System.out.println(emptyString.isPresent());
        System.out.println(emptyString.isEmpty());
        System.out.println(maybe.isPresent());
        System.out.println(maybe.isEmpty());


        //Getting values
        System.out.println(optionalStringDemo.get());

        //System.out.println(emptyString.get()); this will throw an exception
        //System.out.println(maybe.get()); This will throw an exception

        //orElse
        System.out.println(optionalStringDemo.orElse("undefined"));
        System.out.println(emptyString.orElse("undefined"));
        System.out.println(maybe.orElse("undefined or not found"));
        //orElseGet
        String resultoptional = optionalStringDemo.orElseGet(()->{
            System.out.println("Generating Default Value");
            return "default";
        });//This will Not execute the default value as the value co-exist before

            String result = maybe.orElseGet(()->{
                System.out.println("Generating Default Value");
                return "default";
            });
        System.out.println(result);
        System.out.println(resultoptional);

        String emptyResult = emptyString.orElseGet(()->{
            System.out.println("Generating Default Empty Value");
            return "default Empty";
        });

        System.out.println(emptyResult);

        //orElseThrow

        String newResult = maybe.orElseThrow(()->new RuntimeException("String not found"));
        System.out.println(newResult);

        String newResultEmpty = emptyString.orElseThrow(()->new RuntimeException("String variable is empty"));
        System.out.println(newResultEmpty);


    }
}
