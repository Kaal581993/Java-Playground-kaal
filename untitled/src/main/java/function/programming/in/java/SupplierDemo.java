package function.programming.in.java;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier <Double> randomNum=()-> Math.random();
        System.out.println(randomNum.get());

        // Using Method Reference
        Supplier <Double> randomNum2= Math::random;
        System.out.println(randomNum2.get());
    }
}
