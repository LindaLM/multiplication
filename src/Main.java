public class Main {
    public static void main(String[] args) {
        Multiply multiply = new Multiply();

        if (args.length == 3) {
            if (args[0].equals("--alg1") || args[0].equals("alg1")){
                try {
                    String bigInt = multiply.bigIntegerMultiplication(args[1], args[2]);
                    System.out.println(bigInt);
                } catch (NumberFormatException e){
                    System.out.println("Wrong format of number!");
                }

            } else if (args[0].equals("--alg2") || args[0].equals("alg2")) {
                try {
                    String fromScratch = multiply.fromScratchMultiplication(args[1], args[2]);
                    System.out.println(fromScratch);
                } catch (NumberFormatException e){
                    System.out.println("Wrong format of number!");
                }
            } else {
                System.out.println("You didn't choose algorithm!");
            }
        } else {
            System.out.println("Wrong number of arguments!");
        }
    }
}