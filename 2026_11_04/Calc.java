public class Calc {
    
    int num;
    int deno;

    public Calc(int num, int deno) {
        this.num = num;
        this.deno = deno;
    }

    public int divide()  {
   if (deno == 0)
       throw new IllegalArgumentException("Can't divide");

        return num / deno;
    }
    public int multiply()  {
        if (num == 0)
              throw new ArithmeticException("can't multiply");
        return num * deno;

    }

    public boolean isAdult(int age) throws InvalidAgeException {

        if (age <= 0 )
             throw new InvalidAgeException();
        if (age < 18)
            return false;
       else
        return true;

    }


}
