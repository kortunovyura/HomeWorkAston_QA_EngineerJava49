interface Shape {
    double calculateArea();
    double calculatePerimeter();
    String getFillColor();
    String getBorderColor();

    default void displayInfo() {
        System.out.println(this.getClass().getSimpleName() + ":");
        System.out.println("  Цвет заливки: " + getFillColor());
        System.out.println("  Цвет границы: " + getBorderColor());
        System.out.printf("  Периметр: %.2f\n", calculatePerimeter());
        System.out.printf("  Площадь: %.2f\n", calculateArea());
        System.out.println("-------------------------");
    }
}