public class Main {
    public static void main(String[] args) {
        Park myPark = new Park("Притяжение");
        myPark.addAttraction("Американский пирог", "10:00-22:00", 500.0);
        myPark.addAttraction("Намотало на Колесо", "10:00-23:00", 350.0);
        myPark.printAttractions();
    }
}