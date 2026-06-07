
public class Product {

    public String name;
    public String date;
    public String manufacturer;
    public String country;
    public int price;
    public boolean available;

    public Product(String name, String date, String manufacturer, String country, int price, boolean available) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.available = available;
    }

    public String toString() {
        return name + date + "(" + manufacturer + ")" + country + " - " + price + " руб.   Наличие:" + (available ? " На складе" : " Под заказ");
    }
}
