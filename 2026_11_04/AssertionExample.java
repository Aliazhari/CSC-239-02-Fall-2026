public class AssertionExample {

    public static void main(String[] args) {

        int age = 15;

        assert age >= 18 : "Age must be at least 18";

        System.out.println("Access granted!");
    }
}
