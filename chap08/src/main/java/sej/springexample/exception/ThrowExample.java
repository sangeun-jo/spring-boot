package sej.springexample.exception;

public class ThrowExample {
    // throw: use in method
    void validAge(int age) {
        if (age < 19) {
            throw new ArithmeticException("You can't buy soju.");
        } else {
            System.out.println("You can buy soju.");
        }
    }

    //throws: use out of method
    int division(int a, int b) throws ArithmeticException{
        int t = a / b;
        return t;
    }

    public static void main(String arg[]) {
        ThrowExample obj = new ThrowExample();
        //obj.validAge(13);
        try {
            System.out.println(obj.division(15, 0));
        } catch (ArithmeticException e) {
            System.out.println("impasible to division with 0.");
        }

        System.out.println("end");
    }
}
