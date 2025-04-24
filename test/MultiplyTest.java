import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class MultiplyTest {

    @Test
    void fromScratchMultiplication() {
        Multiply multiply = new Multiply();
        Random randomLengths = new Random(100);
        Random randomNumbers = new Random(16);
        Integer equals = 0;
        for (int i = 0; i < 100; i++) {
            int randLength1 = randomLengths.nextInt(20) + 1;
            int randLength2 = randomLengths.nextInt(20) + 1;
            String stringNum1 = "";
            for (int j = 0; j < randLength1; j++) {
                int randNum1 = randomNumbers.nextInt(10);
                stringNum1 += Integer.toString(randNum1);
            }
            String stringNum2 = "";
            for (int j = 0; j < randLength2; j++) {
                int randNum2 = randomNumbers.nextInt(10);
                stringNum2 += Integer.toString(randNum2);
            }
            String bigInt = multiply.bigIntegerMultiplication(stringNum1,stringNum2);
            String fromScratch = multiply.fromScratchMultiplication(stringNum1,stringNum2);
            if (bigInt.equals(fromScratch)){
                equals++;
            }
        }
        Assertions.assertEquals(equals,100);
    }
}