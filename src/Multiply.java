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

    public ArrayList<Integer> stringNumToList(String stringNum){
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

    public String listNumToString(ArrayList<Integer> number){
        String stringNum = "";
        // remove zeros from beginning
        boolean prevZero = number.get(number.size() - 1) == 0;
        // contrariwise number to original
        for (int i = number.size()-1; i >= 0 ; i--) {
            if (number.get(i) == 0 && prevZero){
                prevZero = true;
            } else {
                prevZero = false;
                stringNum += Integer.toString(number.get(i));
            }
        }
        return stringNum;
    }

    public ArrayList<ArrayList<Integer>> subMultiplications(ArrayList<Integer> num1, ArrayList<Integer> num2){
        // list of subtotals of multiplication
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(num2.size());
        int zeros = 0;
        // subtotals will be contrariwise
        for (int i = num2.size() - 1; i >= 0; i--) {
            ArrayList<Integer> subtotal = new ArrayList<>();
            for (int k = 0; k < zeros; k++) {
                subtotal.add(0);
            }
            int restNum = 0;
            int subNum;
            for (int j = num1.size() - 1; j >= 0; j--) {
                subNum = (num1.get(j)*num2.get(i)) + restNum;
                restNum = 0;
                if (subNum >= 10) {
                    restNum = subNum / 10;
                    subNum = subNum % 10;
                }
                subtotal.add(subNum);
            }
            if (restNum > 0) {
                subtotal.add(restNum);
            }
            result.add(subtotal);
            zeros++;
        }
        return result;
    }

    public ArrayList<Integer> sumOfMultiplications(ArrayList<ArrayList<Integer>> all_subtotals){
        ArrayList<Integer> result = new ArrayList<>();
        // sum of submultiplications
        int longest_num = all_subtotals.get(all_subtotals.size()-1).size();
        int restNum = 0;
        int subSum = 0;
        for (int i = 0; i < longest_num; i++) {
            for (ArrayList<Integer> sub : all_subtotals) {
                if (i < sub.size()) {
                    subSum += sub.get(i);
                }
            }
            subSum += restNum;
            restNum = 0;
            if (subSum >= 10) {
                restNum = subSum / 10;
                subSum = subSum % 10;
            }
            result.add(subSum);
            subSum = 0;
        }
        if (restNum > 0) {
            result.add(restNum);
        }
        return result;
    }

    public String fromScratchMultiplication(String stringNum1, String stringNum2){
        try {
            ArrayList<Integer> num1 = this.stringNumToList(stringNum1);
            ArrayList<Integer> num2 = this.stringNumToList(stringNum2);
            // subtotals of multiplication
            ArrayList<ArrayList<Integer>> all_subtotals = this.subMultiplications(num1, num2);
            // sum of submultiplications
            ArrayList<Integer> result = this.sumOfMultiplications(all_subtotals);
            // list to string
            return this.listNumToString(result);
        }  catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong format of number");
        }
    }

}
