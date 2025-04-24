import java.math.BigInteger;

public class Multiply {

    public Multiply(){

    }
    public String bigIntegerMultiplication(String num1, String num2){
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger mult_number = a.multiply(b);
        return mult_number.toString();
    }

}
