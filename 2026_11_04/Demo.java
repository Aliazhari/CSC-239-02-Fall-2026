import java.io.File;
import java.util.Scanner;

public class Demo {
    
    public static void main(String[] args) throws Exception {
        Calc cal = new Calc(20, 10);
        File file = new File("blahblah.txt");
        
        try {
        System.out.println(cal.multiply());
        System.out.println(cal.divide());
        //  Scanner scanner = new Scanner(file);
        System.out.println(cal.isAdult(-15));
       
        }
     
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
           catch (Exception e) {
            System.out.println(e.getMessage());
          
        }
  finally {
        System.out.println("The program finished successful and the file was saved");
  }
    }


}
