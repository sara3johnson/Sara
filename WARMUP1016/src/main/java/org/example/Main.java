package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {3,333,33,23,13};

        Arrays.sort(array);

        System.out.println("Array in order");
        for (int num : array) {
            System.out.print(num + " ");
        }

    }
}