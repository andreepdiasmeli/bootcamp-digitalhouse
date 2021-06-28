package com.mercadolivre;

import java.util.Arrays;
import java.util.Collections;

public class Exercicio1 {

    private static void printArray(Integer[] array){
        for(int i = 0 ; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Integer array[] = { 52, 10, 85, 1324, 01, 13, 62, 30, 12, 127 };
        printArray(array);

        Arrays.sort(array);
        printArray(array);

        Arrays.sort(array, Collections.reverseOrder());
        printArray(array);
    }
}
