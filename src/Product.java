public class Product {

    String name;
    String date;
    String manufacturer;
    String country;
    int price;
    boolean available;

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

    public static void main(String[] args) {
        System.out.println("                             ~~ ДикаяШестерочка ~~");
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung ", "01.02.2025 ", "Samsung Corp.", " Korea  ", 95599, false);
        productsArray[1] = new Product("Apple   ", "11.08.2015 ", "Apple Corp.", "   Indiya ", 88599, true);
        productsArray[2] = new Product("Honor   ", "13.12.2005 ", "Honor Corp.", "   Japan  ", 57659, false);
        productsArray[3] = new Product("Huawei  ", "05.02.2023 ", "Huawei Corp.", "  Finland", 22299, true);
        productsArray[4] = new Product("Meizu   ", "03.10.2025 ", "Meizu Corp.", "   UK     ", 33599, true);
        for (Product product : productsArray) {
            System.out.println(product);
        }
    }
}
