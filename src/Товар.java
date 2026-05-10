public class Товар {
    String name;
    String productionDate;
    String manufacturer;
    String country;
    double price;
    boolean isReserved;

    public Товар(String name, String productionDate, String manufacturer, String country, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void displayInfo() {
        System.out.println("<<< Информация о товаре >>>");
        System.out.println("Название: ---------- " + name);
        System.out.println("Дата производства: - " + productionDate);
        System.out.println("Производитель: ----- " + manufacturer);
        System.out.println("Страна: ------------ " + country);
        System.out.println("Цена: -------------- " + price + " руб.");
        System.out.println("Забронирован: ------ " + (isReserved ? "Да" : "Нет"));
        System.out.println("=================================");
    }

    public static void main(String[] args) {
        Товар myProduct = new Товар("Смартфон", "2026-01-22", "Huawei", "Китай", 17588.8, false);
        myProduct.displayInfo();
    }
}