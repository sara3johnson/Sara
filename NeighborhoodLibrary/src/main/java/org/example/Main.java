package org.example;
import java.util.Scanner;
public class Main {

    private static boolean checkedOut = false;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which book would you like to check out?");
        String bookTitle = scanner.nextLine();





        Book[] bookArray = new Book [20];

        bookArray[0] = new Book (1, "300", "Are you my mother?", false, "");
        bookArray[1] = new Book(2,"111", "Lightening Thief", false, "");
        bookArray[2] = new Book(3,"222","Sam I Am", false, "" );
        bookArray[3] = new Book(4, "333", "The 4 Agreements", false, "");
        bookArray[4] = new Book(5, "444", "The 12 laws of the universe", false,"");
        bookArray[5] = new Book(6, "555", "The Odyssey", false,"");
        bookArray[6] = new Book(7, "666", "Harry Potter", false,"");
        bookArray[7] = new Book(8, "777", "Dracula", false,"");
        bookArray[8] = new Book(9, "888", "The Road", false,"");
        bookArray[9] = new Book(10, "999", "Unwind", false,"");
        bookArray[10] = new Book(11, "100", "After", false,"");
        bookArray[11] = new Book(12,"110", "The Uglies", false, "");
        bookArray[12] = new Book(13, "120", "The Pretties", false, "" );
        bookArray[13] = new Book(14, "130", "The 7 Powers", false, "" );
        bookArray[14] = new Book(15, "140", "Jambalaya", false, "" );
        bookArray[15] = new Book(16, "150", "The Divine", false, "" );
        bookArray[16] = new Book(17, "160", "The Alchemist", false, "" );
        bookArray[17] = new Book(18, "170", "Hunger Games", false, "" );
        bookArray[18] = new Book(19, "180", "Divergent", false, "" );
        bookArray[19] = new Book(20, "190", "Romeo and Juliet", false, "" );







    }
}