package optionals;

import java.util.Optional;

public class FunctionalOperationsDemo {
    public static void main(String[] args) {

        Optional<String> name = Optional.of("Wake up Kaal, The Matrix has you");
        //ifPresent()
        name.ifPresent(value -> {System.out.println(value);
            System.out.println("Follow the white rabbit");});
        name.ifPresent(System.out::println);

        //Null optional will not return anything as it is not initialized

        Optional<String> nullOptional = Optional.ofNullable(null);
        nullOptional.ifPresent(value -> {System.out.println(value);
            System.out.println("Follow the white rabbit");});
        nullOptional.ifPresent(System.out::println);



        //map()

        Optional<String> upperCase = name.map(value->value.toUpperCase());
        System.out.println(upperCase.orElse("Default"));

        Optional<String> upperCasewithMethodReference = name.map(String::toUpperCase);
        System.out.println(upperCasewithMethodReference);
        //filter()

        Optional<String> upperCasenullTest = nullOptional.map(value->value.toUpperCase());
        System.out.println(upperCasenullTest.orElse("Default"));

        Optional<String> temp =name.filter(n->n.startsWith("W"));
        temp.ifPresent(System.out::println);

        name.filter(n ->n.startsWith("K",8)).ifPresent(System.out::println);

        //Combined Operation

        name.filter(n ->n.startsWith("K",8)).map(String::toUpperCase).ifPresent(System.out::println);
    }
}
