package org.example;

public class Book {
    //Small quibble, no need to put the world book in front of the property since the class is named Book
    //create properties
    private int bookId;
    private String bookIsbn;
    private String bookTitle;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int bookId, String bookIsbn, String bookTitle, boolean isCheckedOut, String checkedOutTo) {
        this.bookId = bookId;
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    //You could do the constructor like this for less typing since you know in the beginning it won't be checked out
    //and it's not checked out to anyone
    public Book(int id, String isbn, String title) {
        this.bookId = id;
        this.bookIsbn = isbn;
        this.bookTitle = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    //These are good starts but the methods need some logic.
    public void checkedOut(String usersName) {
        //Here's some pseudo code for you to think about
        //If the book is already checked out, what do you do?

        //if the book is not already checked out, we allow the user to check it out
        //How do we mark that the book is checked out?
        //How do we mark to whom the book is checked out?
    }

    public void checkedIn() {
        //The logic here is going to be the reverse of the logic in checkedOut method
    }
}


