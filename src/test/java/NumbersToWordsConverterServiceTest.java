import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

public class NumbersToWordsConverterServiceTest {
    NumbersToWordsConverterController numberService = new NumbersToWordsConverterController();

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
//            assert(result.equalsIgnoreCase(listOfOneDigitNumbers.get(number)), "message");
            assertTrue("failed at number " + number, result.equalsIgnoreCase(listOfOneDigitNumbers.get(number)));
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
            assertTrue("failed at number " + number + ", result was "+ listOfTwoDigitNumbers.get(x),
                    result.equalsIgnoreCase(listOfTwoDigitNumbers.get(x)));
            x++;
            number = number + 10;
        }


    }
}
