public class Circle extends Shape {


    private int radius;

    public Circle(String color, boolean isFill, int radius) {
        super(color, isFill);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return 3.13 * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", getColor()=" + getColor() + ", isFill()=" + isFill()
                + ", getDateCreated()=" + getDateCreated() + "]";
    }

    

    
}