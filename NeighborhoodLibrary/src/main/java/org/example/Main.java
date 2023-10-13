package org.example;

public class Main {
    public static void main(String[] args) {


        Book[] bookArray = new Book [20];

        bookArray[0] = new Book (1, 000, "Are you my mother?", false, "");
        bookArray[1] = new Book(2,111, "Lightening Thief", false, "");
        bookArray[2] = new Book(3,222,"Sam I Am", false, "" );
        bookArray[3] = new Book(4, 333, "The 4 Agreements", false, "");
        bookArray[4] = new Book(5, 444, "The 12 laws of the universe", false,"");
        bookArray[4] = new Book(5, 555, "The 12 laws of the universe", false,"");
        bookArray[4] = new Book(5, 666, "The 12 laws of the universe", false,"");
        bookArray[4] = new Book(5, 777, "The 12 laws of the universe", false,"");
        bookArray[4] = new Book(5, 888, "The 12 laws of the universe", false,"");
        bookArray[4] = new Book(5, 999, "The 12 laws of the universe", false,"");
        bookArray[4] = new Book(5, 1111, "The 12 laws of the universe", false,"");


        //create a method to check out book title
        public static void checkOut(String bookTitle){
            //perform checkout task
            System.out.println("You are now checking out: " + bookTitle);
        }
        //create a method to check in book title
        public static void checkIn(String bookTitle){
            //perform check in task
            System.out.println("You are now checking in" + bookTitle);
        }

    }
}