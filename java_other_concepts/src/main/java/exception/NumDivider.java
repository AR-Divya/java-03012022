package exception;

public class NumDivider {

    public double divideNumbers(double num1, double num2){
        if(num == 0)
            return 0;
        return num1/num2;
    }

    public double divideNumbersException(double num1, double num2) {
        if (num == 0) throw new ArithmeticException("num2 is 0");
        return num1 / num2;  //throw new ArithmeticException()
    }
}
