package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystemException;

import static java.lang.Exception.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


class BookUnavailableException extends Exception{

}



class Library{
    int booksAvailable=6;

    public void borrowBook(int booksRequested) throws Exception{
            if(booksRequested>booksAvailable){
                throw new Exception("Not enough books available");
            }


        //Interview question: Can you skip the ctach block?
        // The answer is Yes, but it is not recommended
    }
}
public class Main extends Throwable{


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }


        Library li = new Library();

        try {
            li.borrowBook(20);
        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try{

            int [] a= {1,2,3};
            System.out.println(a[6]);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array Element Not Found");
        }catch (Exception e){
             e.printStackTrace();

            throw e;
        }finally{
            //ALWAYS gets EXECUTED
            System.out.println("Finally things are executed smoothly");
        }


//        try{
//            FileReader file1 = new FileReader("abc.txt");
//        }  catch (FileNotFoundException fe) {
//            throw new RuntimeException(fe);
//        }finally{
//            //ALWAYS gets EXECUTED
//            System.out.println("Finally FileReader is executed smoothly");
//        }

        Library li2 = new Library();

        try {
            li2.borrowBook(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


//class Library{
//    int booksAvailable=6;
//
//    public void borrowBook(int booksRequested) throws Exception{
//        if(booksRequested>booksAvailable){
//            throw new Exception("Not enough books available");
//        }
//
//
//        //Interview question: Can you skip the ctach block?
//        // The answer is Yes, but it is not recommended
//    }
//}


//class Library{
//    int booksAvailable=6;
//
//    public void borrowBook(int booksRequested){
//        try{
//            if(booksRequested>booksAvailable){
//                throw new Exception("Not enough books available");
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Book not found in Database");
//        } catch (NullPointerException npe){
//            System.out.println("We have another Null Pointer Exception");
//        } catch (Exception e){
//            System.out.println("Handling via parent Exception, Exception undefined");
//        }finally{
//            System.out.println("Finally the block execution is completed");
//        }
//
//        //Interview question: Can you skip the ctach block?
//        // The answer is Yes, but it is not recommended
//    }
//}

//public void borrowBook(int booksRequested){
//    try{
//        int[] books={101,102,103};
//
//        System.out.println("Books Requested "+ books[booksRequested]);
//    } catch (ArrayIndexOutOfBoundsException e) {
//        System.out.println("Book not found in Database");
//    } catch (NullPointerException npe){
//        System.out.println("We have another Null Pointer Exception");
//    } catch (Exception e){
//        System.out.println("Handling via parent Exception, Exception undefined");
//    }finally{
//        System.out.println("Finally the block execution is completed");
//    }
//
//    //Interview question: Can you skip the ctach block?
//    // The answer is Yes, but it is not recommended
//}