import java.util.ArrayList;
import java.util.List;


public class NumbersToWordsConverterController {

    NumbersToWordsConverterService numbersToWordsConverterService = new NumbersToWordsConverterService();

    public String convertToNumber(int number) {

        if (isTeenNumber(number)) {
            return numbersToWordsConverterService.convertTeenNumbers(number);
        } else {
            return numbersToWordsConverterService.convertDigitsController(number);
        }
    }





    private boolean isTeenNumber(int number) {
        return number > 9 && number < 20;
    }
}
