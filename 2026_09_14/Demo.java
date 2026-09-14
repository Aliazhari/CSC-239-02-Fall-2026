public class Demo {

    public  int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        String name = "Ali";
        int firstNumber = 10;
        int secondNum = 20;
        boolean flag = true;
        System.out.println(firstNumber + secondNum);
        System.out.println(name);
        System.out.println(flag);
        System.out.println("Hello Java");

        if (flag == true) {
            System.out.println("I is true");
        } else {
            System.out.println("It is false");
            System.out.println("You failed");
        }

        Demo d = new Demo();

        int result  = d.add(10, 40);
        System.out.println(result);
        // int i;
        // for (i = 0; i < 10; i++) {
        //     System.out.println(i + 1);
        // }

        // System.out.println(i);

        // int j =  10;
        // while ( j < 10) {
        //     System.out.println(j++);
        // }
       
        int k = 20;
   do {
    System.out.println(k);

   } while(k < 10);

    }
}