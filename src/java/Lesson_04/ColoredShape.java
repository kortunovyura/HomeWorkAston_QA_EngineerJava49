class ColoredShape implements Shape {
    private Shape decoratedShape;
    private String fillColor;
    private String borderColor;

    public ColoredShape(Shape decoratedShape, String fillColor, String borderColor) {
        this.decoratedShape = decoratedShape;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return decoratedShape.calculateArea();
    }

    @Override
    public double calculatePerimeter() {
        return decoratedShape.calculatePerimeter();
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}