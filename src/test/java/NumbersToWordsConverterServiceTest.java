import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.Assert.fail;

public class NumbersToWordsConverterServiceTest {
    NumbersToWordsConverterService numberService = new NumbersToWordsConverterService();


    @Test
    public void convertToWords_WhenInput_1000_ThenOutput_isNotSupported() {
        int number = 1000;
        assertNull(numberService.convertToNumber(number));
//        String result = numberService.convertToNumber(number);
//        assert e


//        AssertionError(new Exception("a"));
    }
    @Test
    public void convertToWords_WhenInput_1_ThenOutput_One() {
        int number = 1;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("one"));
    }

    @Test
    public void convertToWords_WhenInput_0_ThenOutput_Zero() {
        int number = 0;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("zero"));
    }

    @Test
    public void convertToWords_WhenInput_20_ThenOutput_isCorrect() {
        int number = 20;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("twenty"));
    }

    @Test
    public void convertToWords_WhenInput_25_ThenOutput_isCorrect() {
        int number = 47;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("fourty seven"));
    }

    @Test
    public void convertToWords_WhenInput_51_ThenOutput_isCorrect() {
        int number = 25;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("twenty five"));
    }

    @Test
    public void convertToWords_WhenInput_11_ThenOutput_isCorrect() {
        int number = 11;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("eleven"));
    }

    @Test
    public void convertToWords_WhenInput_10_ThenOutput_isCorrect() {
        int number = 10;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("ten"));
    }

    @Test
    public void convertToWords_WhenInput_19_ThenOutput_isCorrect() {
        int number = 19;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("nineteen"));
    }

    @Test
    public void convertToWords_WhenInput_72_ThenOutput_isCorrect() {
        int number = 72;
        String result = numberService.convertToNumber(number);
        assert (result.equalsIgnoreCase("seventy two"));
    }

    @Test
    public void convertToWords_WhenInput_OneDigit_ThenOutput_OneToNine() {
        int number = 0;
        ArrayList<String> listOfOneDigitNumbers = new ArrayList<String>();
        listOfOneDigitNumbers.add("zero");
        listOfOneDigitNumbers.add("one");
        listOfOneDigitNumbers.add("two");
        listOfOneDigitNumbers.add("three");
        listOfOneDigitNumbers.add("four");
        listOfOneDigitNumbers.add("five");
        listOfOneDigitNumbers.add("six");
        listOfOneDigitNumbers.add("seven");
        listOfOneDigitNumbers.add("eight");
        listOfOneDigitNumbers.add("nine");

        while (number < 10) {
            String result = numberService.convertToNumber(number);
            assertTrue("failed at number " + number + ", result was " + listOfOneDigitNumbers.get(number), result.equalsIgnoreCase(listOfOneDigitNumbers.get(number)));
            number++;
        }
    }

    @Test
    public void convertToWords_WhenInput_TwoDigit_ThenOutput_OneToNinetyNine() {
        int number = 20;
        ArrayList<String> listOfTwoDigitNumbers = new ArrayList<String>();
        listOfTwoDigitNumbers.add("twenty");
        listOfTwoDigitNumbers.add("thirty");
        listOfTwoDigitNumbers.add("fourty");
        listOfTwoDigitNumbers.add("fifty");
        listOfTwoDigitNumbers.add("sixty");
        listOfTwoDigitNumbers.add("seventy");
        listOfTwoDigitNumbers.add("eighty");
        listOfTwoDigitNumbers.add("ninety");
        int x = 0;

        while (number < 100) {
            String result = numberService.convertToNumber(number);
            assertTrue("failed at number " + number + ", result was " + listOfTwoDigitNumbers.get(x),
                    result.equalsIgnoreCase(listOfTwoDigitNumbers.get(x)));
            x++;
            number = number + 10;
        }
    }

    @Test
    public void convertToWords_WhenInput_TwoDigitWithEnding_ThenOutput_IsCorrect() {
        int number = 11;
        ArrayList<String> listOfTwoDigitNumbers = new ArrayList<String>();
        listOfTwoDigitNumbers.add("eleven");
        listOfTwoDigitNumbers.add("twenty two");
        listOfTwoDigitNumbers.add("thirty three");
        listOfTwoDigitNumbers.add("fourty four");
        listOfTwoDigitNumbers.add("fifty five");
        listOfTwoDigitNumbers.add("sixty six");
        listOfTwoDigitNumbers.add("seventy seven");
        listOfTwoDigitNumbers.add("eighty eight");
        listOfTwoDigitNumbers.add("ninety nine");
        int x = 0;

        while (number < 100) {
            String result = numberService.convertToNumber(number);
            assertTrue("failed at number " + number + ", result was " + listOfTwoDigitNumbers.get(x),
                    result.equalsIgnoreCase(listOfTwoDigitNumbers.get(x)));

                number = number + 11;
                x++;
        }
    }


    @Test
    public void convertToWords_WhenInput_ThreeDigit_ThenOutput_IsCorrect() {
        int number = 100;
        ArrayList<String> listOfTwoDigitNumbers = new ArrayList<String>();
        listOfTwoDigitNumbers.add("one hundred");
        listOfTwoDigitNumbers.add("one hundred seventy three");
        listOfTwoDigitNumbers.add("two hundred fourty six");
        listOfTwoDigitNumbers.add("three hundred nineteen");
//        listOfTwoDigitNumbers.add("fifty five");
//        listOfTwoDigitNumbers.add("sixty six");
//        listOfTwoDigitNumbers.add("seventy seven");
//        listOfTwoDigitNumbers.add("eighty eight");
//        listOfTwoDigitNumbers.add("ninety nine");
        int x = 0;

        while (number < 350) {
            String result = numberService.convertToNumber(number);
            assertTrue("failed at number " + number + ", expected " + listOfTwoDigitNumbers.get(x) +", result: "+ result.toString(),
                    result.equalsIgnoreCase(listOfTwoDigitNumbers.get(x)));
            number = number + 73;
            x++;
        }
    }


}
