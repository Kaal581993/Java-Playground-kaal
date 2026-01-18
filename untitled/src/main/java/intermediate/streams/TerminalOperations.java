package intermediate.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(10,20,30,45,50,65,70,85);

        //reduce()
        Stream<Integer> integerStream = numbers.stream();
        int sum = integerStream.reduce(0, (acc,num) ->acc+num);
        System.out.println("The Sum of all numbers in array "+numbers+" is:\n"+sum);

        System.out.println("\n The sum with the short hand\n");
        Stream<Integer> integerStream2 = numbers.stream();
        int sum2 = integerStream2.reduce(0, Integer::sum);
        System.out.println("The Sum of all numbers in array "+numbers+" is:\n"+sum);

        int total=numbers.stream().reduce(0, Integer::sum);
        System.out.println("\nThe Total of all numbers in array "+numbers+" is:\n"+total);

        //collect()

        List<Integer> evenNumbers = numbers.stream().filter(n -> n%2==0).collect(Collectors.toList());
        System.out.println("\nThe List of Even Numbers in array "+numbers+" is:\n"+evenNumbers);

        List<Integer> oddNumbers = numbers.stream().filter(n -> n%2!=0).collect(Collectors.toList());
        System.out.println("\nThe List of Odd Numbers in array "+numbers+" is:\n"+oddNumbers);

        Set<Integer> evenNumbersSet = numbers.stream().filter(n -> n%2==0).collect(Collectors.toSet());
        System.out.println("\nThe Set of Even Numbers in array "+numbers+" is:\n"+evenNumbersSet);

        Set<Integer> oddNumbersSet = numbers.stream().filter(n -> n%2!=0).collect(Collectors.toSet());
        System.out.println("\nThe Set of Odd Numbers in array "+numbers+" is:\n"+oddNumbersSet);

        //find and match
        System.out.println("\nFind First element in Array"+numbers+"\n");
        System.out.println(numbers.stream().findFirst().get());
        System.out.println("\nFind Any element in Array"+numbers+"\n");
        System.out.println(numbers.stream().findAny().get());

        System.out.println("\nMatching all element in Array has 45"+numbers+"\n");
        //System.out.println(numbers.stream().allMatch(num -> num==45));
        boolean has45 = numbers.stream().allMatch(num -> num==45);
        System.out.println(has45);

        System.out.println("\nMatching if any element in Array has 45"+numbers+"\n");
        System.out.println(numbers.stream().anyMatch(num -> num==45));

        System.out.println("\nMatching if any element in Array has 41"+numbers+"\n");
        System.out.println(numbers.stream().anyMatch(num -> num==41));

        System.out.println("\nMatching if no any element in Array has 41"+numbers+"\n");
        System.out.println(numbers.stream().noneMatch(num -> num==41));

        // iteration
        numbers.stream().forEach(n->System.out.println(n));
        numbers.stream().forEach(System.out::println);

    }
}
