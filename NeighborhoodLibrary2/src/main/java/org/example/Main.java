package org.example;

import java.util.Scanner;

/*
You have the skeleton of what needs to be done, but the check out doesn't work.
You need to work on those methods in the book class to perform the actual logic.
I mean it looks nice, so work on that part and once you have it in the rest should fall into place.
 */
public class Main {
    private static boolean checkedOut = false;
    private static String checkedOutTo = "";
    private static boolean availBooks = true;

    public static void main(String[] args) {

        Book[] bookInventory = new Book [20];

        bookInventory[0] = new Book (1, "300", "Are you my mother?", false, "");
        bookInventory[1] = new Book(2,"111", "Lightening Thief", false, "");
        bookInventory[2] = new Book(3,"222","Sam I Am", false, "" );
        bookInventory[3] = new Book(4, "333", "The 4 Agreements", false, "");
        bookInventory[4] = new Book(5, "444", "The 12 laws of the universe", false,"");
        bookInventory[5] = new Book(6, "555", "The Odyssey", false,"");
        bookInventory[6] = new Book(7, "666", "Harry Potter", false,"");
        bookInventory[7] = new Book(8, "777", "Dracula", false,"");
        bookInventory[8] = new Book(9, "888", "The Road", false,"");
        bookInventory[9] = new Book(10, "999", "Unwind", false,"");
        bookInventory[10] = new Book(11, "100", "After", false,"");
        bookInventory[11] = new Book(12,"110", "The Uglies", false, "");
        bookInventory[12] = new Book(13, "120", "The Pretties", false, "" );
        bookInventory[13] = new Book(14, "130", "The 7 Powers", false, "" );
        bookInventory[14] = new Book(15, "140", "Jambalaya", false, "" );
        bookInventory[15] = new Book(16, "150", "The Divine", false, "" );
        bookInventory[16] = new Book(17, "160", "The Alchemist", false, "" );
        bookInventory[17] = new Book(18, "170", "Hunger Games", false, "" );
        bookInventory[18] = new Book(19, "180", "Divergent", false, "" );
        bookInventory[19] = new Book(20, "190", "Romeo and Juliet", false, "" );

        Scanner scanner = new Scanner(System.in);
        //ask user what they want

        while (true) {
            System.out.println("Welcome to The Library Home Screen");
            System.out.println("Select an option:");
            System.out.println("1- Show available books.");
            System.out.println("2- Show checked out books.");
            System.out.println("3- EXIT");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    displayAvailableBooks(bookInventory);
                    break;
                case 2:
                    displayCheckedOutBooks(bookInventory);
                    break;
                case 3:
                    System.out.println("Thank you, have a great day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("I'm sorry, that is not a valid response. Please choose either 1, 2, or 3.");
                    break;
            }
        }
    }

    public static void displayAvailableBooks(Book[] books) { // Pass the bookArray as a parameter
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean availBooks = false;

            for (Book book : books) {
                if (book != null && !book.isCheckedOut()) {
                    System.out.println("ID: " + book.getBookId() + ", Title: " + book.getBookTitle());
                    availBooks = true;
                }
            }

            if (!availBooks) {
                System.out.println("Sorry, no books are available.");
                break;
            }

            System.out.println("Please make your selection by typing the title of the book: ");
            System.out.println("Or enter 0 to go back to The Library Home Screen.");
            String titleOfBook = scanner.nextLine();

            if (titleOfBook.equals("0")) {
                break;
            }

            boolean bookFound = false;
            for (Book book : books) {
                if (book != null && book.getBookTitle().equalsIgnoreCase(titleOfBook) && !book.isCheckedOut()) {
                    System.out.println("If you would like to check out this book, please enter your name:");
                    String usersName = scanner.nextLine();

                    book.checkedOut(usersName);
                    System.out.println("Thank you " + usersName + ", this book has been checked out!");
                    bookFound = true;
                    break;
                }
            }

                if (!bookFound) {
                System.out.println("Book not found.");
            }
        }
    }

                 public static void displayCheckedOutBooks(Book[] books) { // Pass the bookArray as a parameter
                Scanner scanner = new Scanner(System.in);
                boolean exit = false;

               while (!exit) {
                   boolean checkedOutBooks = false;

                   for (Book book : books) { // Iterate over the bookArray
                       if (book != null && book.isCheckedOut()) { // Check for null and checked out status
                           System.out.println("ID: " + book.getBookId() + ", Title: " + book.getBookTitle() + ", is checked out by: " + book.getCheckedOutTo());
                           checkedOutBooks = true;
                       }
                   }

                   if (!checkedOutBooks) {
                       System.out.println("No books have been checked out.");
                       break;
                   }

                   System.out.println("If you'd like to return a book, please enter the book ID. Or enter 0 to return back to The Library Home Screen");
                   int bookID = scanner.nextInt();
                   scanner.nextLine();

                   if (bookID == 0) {
                       exit = true;
                   } else {
                       boolean bookFound = false;
                       for (Book book : books) {
                           if (book != null && book.getBookId() == bookID && book.isCheckedOut()) { // Check for null and checked out status
                               book.checkedIn();
                               System.out.println("Thank you, book has been checked in.");
                               bookFound = true;
                               break;
                           }
                       }

                       if (!bookFound) {
                           System.out.println("No book found.");
                       }
                   }
                   scanner.close();
               }}}