import org.junit.Test;

import java.util.ArrayList;

public class NumbersToWordsConverterServiceTest {
    NumbersToWordsConverterController numberService = new NumbersToWordsConverterController();

    @Test
    public void convertToWords_WhenInput_1_ThenOutput_One(){
        int number = 1;
        String result = numberService.convertToNumber(number);
        assert(result.equalsIgnoreCase("one"));
    }

    @Test
    public void convertToWords_WhenInput_20_ThenOutput_isCorrect(){
        int number = 20;
        String result = numberService.convertToNumber(number);
        assert(result.equalsIgnoreCase("twenty"));
    }

    @Test
    public void convertToWords_WhenInput_25_ThenOutput_isCorrect(){
        int number = 47;
        String result = numberService.convertToNumber(number);
        assert(result.equalsIgnoreCase("fourty seven"));
    }

    @Test
    public void convertToWords_WhenInput_51_ThenOutput_isCorrect(){
        int number = 25;
        String result = numberService.convertToNumber(number);
        assert(result.equalsIgnoreCase("twenty five"));
    }

    @Test
    public void convertToWords_WhenInput_11_ThenOutput_isCorrect(){
        int number = 11;
        String result = numberService.convertToNumber(number);
        assert(result.equalsIgnoreCase("eleven"));
    }

    @Test
    public void convertToWords_WhenInput_72_ThenOutput_isCorrect(){
        int number = 72;
        String result = numberService.convertToNumber(number);
        assert(result.equalsIgnoreCase("seventy two"));
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
            assert (result.equalsIgnoreCase(listOfOneDigitNumbers.get(number)));

            number++;
        }
    }

//        @Test
//        public void convertToWords_WhenInput_TwoDigit_ThenOutput_OneToNinetyNine() {
//            int number = 20;
//            ArrayList<String> listOfTwoDigitNumbers = new ArrayList<String>();
//            listOfTwoDigitNumbers.add("twenty");
//            listOfTwoDigitNumbers.add("thirty");
//            listOfTwoDigitNumbers.add("fourty");
//            listOfTwoDigitNumbers.add("sixty");
//            listOfTwoDigitNumbers.add("seventy");
//            listOfTwoDigitNumbers.add("eighty");
//            listOfTwoDigitNumbers.add("ninety");
//
//            while (number < 100) {
//                String result = numberService.convertToNumber(number);
//                assert (result.equalsIgnoreCase(listOfTwoDigitNumbers.get(number)));
//
//                number = number + 10;
//            }
//
//
//        }
}
