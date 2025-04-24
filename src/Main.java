import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Multiply multiply = new Multiply();
        try {
            System.out.println("multiply with bigInteger: " + multiply.bigIntegerMultiplication("098776665", "9786543"));
        } catch (NumberFormatException e){
            System.out.println(e);
        }

        try {
            ArrayList<Integer> num = multiply.loadNumber("2233fgghgh445678");
            System.out.println(num.toString());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}