import java.util.Scanner;

public class Calc {
    
    public static void main(String[] args) {
        int x;
        int y;
        int result;
   System.out.println("Random is: ");
        System.out.println((int) (Math.random() * 10));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first number: ");
       x = scanner.nextInt();
       
        // x = Integer.parseInt(args[0]);
        // y = Integer.parseInt(args[2]);

        System.out.println("Please enter the second number: ");
        y = scanner.nextInt();
        // String ope = args[1];
        System.out.println("Enter an operator: +, -, * or /");
        String ope = scanner.next();

        switch(ope) {
            case "+":
            result = x + y;
            System.out.println(result);
            break;
            case "-":
            result = x - y;
            System.out.println(result);
            break;
            case "*":
            result = x * y;
            System.out.println(result);
            break;
            case "/":
            result = x / y;
            System.out.println(result);
            break;
            default:
                System.out.println("Invalid operator");
        }
        
    }
}
