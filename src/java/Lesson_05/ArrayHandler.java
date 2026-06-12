class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class ArrayHandler {

    public static void main(String[] args) {
        String[][] correctArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        String[][] dataErrorArray = {
            {"1", "2", "3", "4"},
            {"5", "A", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        String[][] sizeErrorArray = {
            {"1", "2"},
            {"3", "4"}
        };

        System.out.println("--- Тест 1: Корректный массив ---");
        processArray(correctArray);

        System.out.println("\n--- Тест 2: Ошибка данных ---");
        processArray(dataErrorArray);

        System.out.println("\n--- Тест 3: Ошибка размера ---");
        processArray(sizeErrorArray);
    }

    public static void processArray(String[][] arr) {
        try {
            int result = calculateSum(arr);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static int calculateSum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Массив должен иметь 4 строки.");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Массив должен иметь 4 столбца. Ошибка в строке: " + i);
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "x" + j + "]: " + arr[i][j]);
                }
            }
        }
        return sum;
    }
}