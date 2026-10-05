public class Demo {
    
     public static void print(Shape o) {
        System.out.println(o.area());
    }

    public static void main(String[] args) {
        Square square = new Square("Red", true, 4);

        print(square);

        Circle circle = new Circle("Black", false, 3);
        print(circle);
    }
}
