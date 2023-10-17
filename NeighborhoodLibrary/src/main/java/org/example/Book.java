package org.example;


public class Book {

    //create properties
    private int bookId;
    private String bookIsbn;
    private String bookTitle;
    private boolean isCheckedOut;
    private String checkedOutTo;


    //create getters and setters for properties
    public Book(int bookId, String bookIsbn, String bookTitle, boolean isCheckedOut, String checkedOutTo) {
        this.bookId = bookId;
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
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

    //method to checkout
    public void checkedOut(String checkedOutTo){
        this.isCheckedOut = true;
        this.checkedOutTo = checkedOutTo;
    }

    public void checkedIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }


}
