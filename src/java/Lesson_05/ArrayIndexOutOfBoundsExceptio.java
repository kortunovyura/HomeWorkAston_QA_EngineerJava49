public class ArrayIndexOutOfBoundsExceptio{
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        try {
            System.out.println("Попытка доступа к элементу: " + numbers[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: Индекс массива вышел за пределы допустимого диапазона!");
            System.err.println("Сообщение исключения: " + e.getMessage());
        }
        System.out.println("Программа продолжает работу после блока try-catch.");
    }
}