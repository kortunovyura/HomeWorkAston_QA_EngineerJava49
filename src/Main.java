public class Main {
    public static void main(String[] args) {
        checkSumSign();
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

}