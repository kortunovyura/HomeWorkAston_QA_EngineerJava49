
import java.util.ArrayList;
import java.util.List;

public class Park {
    public String parkName;
    public List<Attraction> attractions;

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String workingHours, double price) {
        attractions.add(new Attraction(name, workingHours, price));
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double price;

        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println("Парк: " + parkName +
                    ", Аттракцион: " + attractionName +
                    ", Время: " + workingHours +
                    ", Цена: " + price + " руб.");
        }
    }

    public void printAttractions() {
        for (Attraction attr : attractions) {
            attr.displayInfo(this.parkName);
        }
    }

    public static void main(String[] args) {
        Park myPark = new Park("Притяжение");
        myPark.addAttraction("Американский пирог", "10:00-22:00", 500.0);
        myPark.addAttraction("Намотало на Колесо", "10:00-23:00", 350.0);
        myPark.printAttractions();
    }
}