package utils;

import java.util.Random;

public class randomPoss {

    public static int randomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n - 1) + 1;
    }

    //array[i]
    public static int[] randomArray(int maxNumber, int amount) {
        int[] array = new int[amount];
        for (int i = 0; i < array.length; i++) {

            int temp = randomNumber(maxNumber);
            if (!existe(array, temp)) {
                array[i] = temp;
                i=i+1;
            }
            i=i-1;
        }
        return array;
    }

    private static boolean existe(int[] array, int temp) {
        for (int elemento : array) {
            if (elemento == temp) {
                return true; // El número ya existe en el array
            }
        }
        return false;
    }
}