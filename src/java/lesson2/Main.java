package java.lesson2;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        twoNumbers();
    }


    public static void printThreeWords() {
        System.out.print("Orange \nBanana \nApple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = -5;
        int sum = a + b;
        if (sum >= 0) {
            System.out.print("Сумма положительная");
        } else {
            System.out.print("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.print("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.print("Желтый");
        } else {
            System.out.print("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 0;
        if (a >= b) {
            System.out.print("a >= b");
        } else {
            System.out.print("a < b");
        }
    }


    boolean result = twoNumbers();
        System.out.println(result);
    public boolean twoNumbers() {
        byte a = 5;
        byte b = 5;
        byte sum = (byte) (a + b);
        return sum >= 10 && sum <= 20;
    }

    public static void fullInteger() {
        byte a = 5;
        if (a < 0) {
            System.out.print("Число отрицательное");
        } else {
            System.out.print("Число положительное");
        }
    }

    public static boolean mainFull(int number) {
        return number < 0;
    }

    public static void stringInteger(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    public static boolean bissextile(int a) {
        return (a % 400 == 0) || ((a % 4 == 0) && (a % 100 != 0));
    }

    public static void main(String[] args) {
        int year = 2028;
        System.out.println(year + " -> " + bissextile(year));
    }

    public static void array() {
        byte[] b = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (byte i = 0; i < b.length; i++) {
            b[i] ^= 1;
        }
        System.out.print(Arrays.toString(b));
    }

    public static void array100() {
        byte[] b = new byte[100];
        for (byte i = 0; i < b.length; i++) {
            b[i] = (byte) (i + 1);
        }
        System.out.print(Arrays.toString(b));
    }

    public static void array12() {
        byte[] b = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (byte i = 0; i < b.length; i++) {
            if (b[i] < 6) {
                b[i] *= 2;
            }
        }
        System.out.print(Arrays.toString(b));
    }

    public static void squareArray() {
        byte b = 3;
        byte[][] a = new byte[b][b];
        for (byte i = 0; i < b; i++) {
            a[i][i] = 1;
        }
        for (byte i = 0; i < b; i++) {
            for (byte j = 0; j < b; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static void lenValue() {
        int len = 5;
        int initialValue = 8888;
        int[] c = new int[len];
        Arrays.fill(c, initialValue);
        System.out.print(Arrays.toString(c));
    }
}