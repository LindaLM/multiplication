import java.math.BigInteger;
import java.util.ArrayList;

public class Multiply {

    public Multiply(){

    }
    public String bigIntegerMultiplication(String num1, String num2){
        try {
            BigInteger a = new BigInteger(num1);
            BigInteger b = new BigInteger(num2);
            BigInteger mult_number = a.multiply(b);
            return mult_number.toString();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong format of number");
        }
    }

    public ArrayList<Integer> loadNumber(String stringNum){
        ArrayList<Integer> number = new ArrayList<>(stringNum.length());
        for (int i = 0; i < stringNum.length(); i++) {
            char charNum = stringNum.charAt(i);
            if (Character.isDigit(charNum)) {
                int intNum = Character.getNumericValue(charNum);
                number.add(intNum);
            } else {
                throw new NumberFormatException("Wrong format of number");
            }
        }
        return number;
    }

}
