package org.example;

public enum BreadLength {

    FOUR_INCHES(4),
    EIGHT_INCHES(8),
    TWELVE_INCHES(12);

    private int lengthInches;

    BreadLength(int lengthInches){
        this.lengthInches = lengthInches;
    }

    public int getLengthInches(){
        return lengthInches;
    }


}
