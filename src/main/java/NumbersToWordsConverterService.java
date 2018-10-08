import java.util.ArrayList;
import java.util.List;

public class NumbersToWordsConverterService {

    //    NumberWords numberWords = new NumberWords();
    private static final Integer FIRST_POSITION = 0;
    private static final Integer SECOND_POSITION = 1;
    private static final Integer THIRD_POSITION = 2;
    StringBuilder str = new StringBuilder();

    public String convertDigitsController(int number) {
        List<Integer> digits = listOfIntegers(number);

        for (int digitPosition = digits.size() - 1; digitPosition >= 0; digitPosition--) {
            if (digitPosition == SECOND_POSITION) { //currently supports up to 99

                addDoubleDigitWords(digits, str, digitPosition);
            } else if (digitPosition == FIRST_POSITION) {
                if (!isZeroAfterSecondDigit(digits, str, digitPosition)) {
                    addSpacingBetweenWords(digits.size(), str);
                    str.append(convertSingleDigit(digits.get(digitPosition)));
                }
            }
        }
        return String.valueOf(str);
    }

    public String convertTeenNumbers(int number) {

        str.append(convertTeensDigit(number));

        return String.valueOf(str);
    }

    private void addDoubleDigitWords(List<Integer> digits, StringBuilder str, int digitPosition) {
        str.append(convertDoubleDigit(digits.get(digitPosition)));
    }



    private void addSpacingBetweenWords(int digitsSize, StringBuilder str) {
        if (digitsSize != 1) {
            str.append(" ");
        }
    }

    private boolean isZeroAfterSecondDigit(List<Integer> digits, StringBuilder str, int y) {
        return digits.get(y) == 0 && !str.toString().isEmpty();
    }


    private NumberWords convertDoubleDigit(int number) {
        switch (number) {
            case 2:
                return NumberWords.TWENTY;
            case 3:
                return NumberWords.THIRTY;
            case 4:
                return NumberWords.FOURTY;
            case 5:
                return NumberWords.FIFTY;
            case 6:
                return NumberWords.SIXTY;
            case 7:
                return NumberWords.SEVENTY;
            case 8:
                return NumberWords.EIGHTY;
            case 9:
                return NumberWords.NINETY;
        }
        return NumberWords.DEFAULT;
    }

    private NumberWords convertTeensDigit(int number) {
        switch (number) {
            case 10:
                return NumberWords.TEN;
            case 11:
                return NumberWords.ELEVEN;
            case 12:
                return NumberWords.TWELVE;
            case 13:
                return NumberWords.THIRTEEN;
            case 14:
                return NumberWords.FOURTEEN;
            case 15:
                return NumberWords.FIFTEEN;
            case 16:
                return NumberWords.SIXTEEN;
            case 17:
                return NumberWords.SEVENTEEN;
            case 18:
                return NumberWords.EIGHTEEN;
            case 19:
                return NumberWords.NINETEEN;
        }
        return NumberWords.DEFAULT;
    }


    private NumberWords convertSingleDigit(int number) {
        switch (number) {
            case 0:
                return NumberWords.ZERO;
            case 1:
                return NumberWords.ONE;
            case 2:
                return NumberWords.TWO;
            case 3:
                return NumberWords.THREE;
            case 4:
                return NumberWords.FOUR;
            case 5:
                return NumberWords.FIVE;
            case 6:
                return NumberWords.SIX;
            case 7:
                return NumberWords.SEVEN;
            case 8:
                return NumberWords.EIGHT;
            case 9:
                return NumberWords.NINE;
        }

        return NumberWords.DEFAULT;
    }

    private List<Integer> listOfIntegers(int number) {
        int splitNumber = number;
        List<Integer> digits = new ArrayList<Integer>();

        for (int x = 0; x < sizeOfNumber(number); x++) {
            digits.add(splitNumber % 10);
            splitNumber = splitNumber / 10;
        }
        return digits;
    }

    private int sizeOfNumber(int number) {
        if (number < 10) {
            return 1;
        } else if (number < 100) {
            return 2;
        } else if (number < 1000) {
            return 3;
        } else {
            return 0; //currently not supporting numbers above 999
        }
    }
}
