package function.programming.in.java;

import java.util.function.Function;

@FunctionalInterface
interface BookActionDemo{
    void readBook();
}

@FunctionalInterface
interface BookReadOperation{
    void add(int a, int b);
}

public class FunctionalProgramming {

    public static Function<Integer, Integer> addFunction =(a) -> a + 6;
    public static Function<Integer, Integer> substractFunction =(a) -> a - 10;
    public static Function<Integer, Integer> combinedFunction =addFunction.andThen(substractFunction);

    public static void main(String[] args){

        BookActionDemo readBook = ()->{
            System.out.println("Book Reading in Progress");
        };

        BookActionDemo readBook2 =() -> System.out.println("Book Reading in Progress");


        readBook.readBook();
        readBook2.readBook();

//        int s=10,f=15;
        BookReadOperation operation1 = (int s,int f)->{
            System.out.println(s+f);
        };
//        int a=30,b=40;
        BookReadOperation operation2 =(int a, int b) -> System.out.println(a+b);


        operation1.add(15,30);
        operation2.add(20,50);

        new Thread(()->System.out.println("New thread started")).start();

        System.out.println(addFunction.apply(100));
        System.out.println(substractFunction.apply(100));
        System.out.println(combinedFunction.apply(100));


    }
}
