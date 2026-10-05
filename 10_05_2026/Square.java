

public class Square extends Shape {
    
    private double side;

    public Square(String color, boolean isFill, double side) {
        super(color, isFill);
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return side * 4;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Square [side=" + side + ", getColor()=" + getColor() + ", isFill()=" + isFill() + ", getDateCreated()="
                + getDateCreated() + "]";
    }

    
    
}
