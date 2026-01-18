package function.programming.in.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DifferentSourcesDemo {

    /**
     * Collection: eg collection.stream
     * Arrays: eg: Arrays.stream()
     * Specific Values: eg Stream.of("a","b","c");
     * Functions: Eg Stream.iterate(0,n-> n+2);
     * Files eg. Files.lines(path)
     * Empty Stream eg. Stream.empty()
     *
     * */


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream <Integer> integerStream = numbers.stream();
        integerStream.forEach(System.out::println);

        int [] numberArray={1,2,3,4,5};
        IntStream arrayStream= Arrays.stream(numberArray);
        arrayStream.forEach(System.out::println);

        Stream<String> stringStream= Stream.of("a","b","c");
        stringStream.forEach(System.out::println);


        Stream<Integer> integerStream1 = Stream.iterate(0,n-> n+2);
        integerStream1.forEach(System.out::println);

        try {
            Stream<String> fileStream = Files.lines(Path.of("Path.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stream<String> emptyStream = Stream.empty();


    }
}
