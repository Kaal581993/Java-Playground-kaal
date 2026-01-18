package streams.pracctice.examples;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("Apple","Banana","Cherry");
        for (String fruit: items)
            System.out.println(fruit);

        System.out.println("\nUsing Streams");

        Stream<String> streams = items.stream();
       // streams.forEach((item)-> System.out.println(item));
        // stream object can be used once only
        streams.forEach(System.out::println);

        System.out.println("\n Filtering Stream");
        Stream<String> Filteringstream = items.stream();
        Stream<String> filteredStream = Filteringstream.filter(name -> name.startsWith("B"));
        filteredStream.forEach(System.out::println);

        items.stream().filter(name-> name.startsWith("C")).forEach(System.out::println);

        /**
         *
         * USE CASES:
         *
         * 1: Filtering
         * 2: Mapping
         * 3: Aggregation
         * 4: Searching
         * 5: Iteration
         *
         * */

    }
}
