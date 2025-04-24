
public class Main {
    public static void main(String[] args) {

        Multiply multiply = new Multiply();

        try {
            String bigInt = multiply.bigIntegerMultiplication("098776", "097");
            String fromScratch = multiply.fromScratchMultiplication("098776", "097");
            System.out.println("multiply with bigInteger: " + bigInt);
            System.out.println("multiply from scratch: " + fromScratch);
            if (bigInt.equals(fromScratch)){
                System.out.println("multiplications are equal");
            }
        } catch (NumberFormatException e){
            System.out.println(e);
        }
    }
}