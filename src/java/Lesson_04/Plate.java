

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int amount) {
        food += amount;
        System.out.println("В миску добавлено " + amount + " еды. Теперь: " + food);
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public int getFood() {
        return food;
    }
}