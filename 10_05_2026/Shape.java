import java.util.Date;

public class Shape {
    
    private String color;
    private boolean isFill;
    private Date dateCreated;

    public Shape(String color, boolean isFill) {
        this.color = color;
        this.isFill = isFill;
        this.dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFill() {
        return isFill;
    }

    public void setFill(boolean isFill) {
        this.isFill = isFill;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double area() {
        return 0.0;
    }
    public double perimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Shape [color=" + color + ", isFill=" + isFill + ", dateCreated=" + dateCreated + "]";
    }

    

    


}
