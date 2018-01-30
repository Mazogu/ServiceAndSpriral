package com.example.micha.services.spiral;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micha on 1/29/2018.
 */

public class SpiralArray {

    public static void main(String[] args) {
        List<Integer> test = spiral(new int[][]{{2,5,7},{3,4,8},{9,10,22}});
        System.out.println(test.toString());

    }

    private static List<Integer> spiral(int[][] array){
        int count = array.length * array[0].length;
        List<Integer> order = new ArrayList<>(count);
        int upperBound = 0;
        int lowerBound = array.length;
        int leftBound = 0;
        int rightBound = array[0].length;
        int num = 0;
        while(num < count){
            for (int i = leftBound; i < rightBound; i++) {
                order.add(array[upperBound][i]);
                num++;
            }
            upperBound++;
            rightBound--;
            for (int i = upperBound; i < lowerBound; i++) {
                order.add(array[i][rightBound]);
                num++;
            }
            lowerBound--;

            for (int i = rightBound-1; i >= leftBound ; i--) {
                order.add(array[lowerBound][i]);
                num++;
            }

            for (int i = lowerBound-1; i >= upperBound ; i--) {
                order.add(array[i][leftBound]);
                num++;
            }
            leftBound++;
        }

        return order;
    }
}
