

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        this.satiety = false;
        catCount++;
    }

    public void eat(Plate plate, int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть больше нуля.");
            return;
        }

        if (!satiety) {
            if (plate.decreaseFood(amount)) {
                satiety = true;
                System.out.println(name + " поел и теперь сыт.");
            } else {
                System.out.println(name + " не поел, еды мало.");
            }
        } else {
            System.out.println(name + " уже сыт.");
        }
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
