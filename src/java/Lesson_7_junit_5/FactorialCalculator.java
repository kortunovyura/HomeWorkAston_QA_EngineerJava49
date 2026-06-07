public class FactorialCalculator{
      public long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть больше или равно 0");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
