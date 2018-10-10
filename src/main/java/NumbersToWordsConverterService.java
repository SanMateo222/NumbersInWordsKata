import java.util.ArrayList;
import java.util.List;

public class NumbersToWordsConverterService {

    private static final Integer MAX_SUPPORTED_NUMBER = 999;
    private static final Integer FIRST_POSITION = 0;
    private static final Integer SECOND_POSITION = 1;
    private static final Integer THIRD_POSITION = 2;

    public String convertToNumber(int number) {
        try {
            isNumberSupportedCheck(number);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder str = new StringBuilder();
        List<Integer> digits = listOfIntegers(number);

        for (int digitPosition = digits.size() - 1; digitPosition >= 0; digitPosition--) {
            if (digitPosition == THIRD_POSITION) {
                addThirdDigitWords(str, digits, digitPosition);
            } else if (digitPosition == SECOND_POSITION) {
                addSecondDigitWords(digits, str, digitPosition);
            } else if (digitPosition == FIRST_POSITION && !isTeenNumber(digits)) {
                addFirstDigitWord(str, digits, digitPosition);
            }
        }
        return String.valueOf(str);
    }

    private void isNumberSupportedCheck(int number) throws Exception {
        if (number > MAX_SUPPORTED_NUMBER) {
            throw new Exception("Currently supporting numbers up to " + MAX_SUPPORTED_NUMBER
                    + ", while input number was " +number);
        }
    }

    private void addTeenDigitWords(StringBuilder str, List<Integer> digits) {
        int number = digits.get(0);
        addSpacingBetweenWords(digits.size(), str, 1);
        str.append(convertTeensDigit(number));
    }

    private boolean isTeenNumber(List<Integer> number) {
        return number.size() > 1 && number.get(1) == 1;
    }

    private void addThirdDigitWords(StringBuilder str, List<Integer> digits, int digitPosition) {
        str.append(convertSingleDigit(digits.get(digitPosition)));
        str.append(" ");
        str.append(NumberWords.HUNDRED);
    }

    private void addFirstDigitWord(StringBuilder str, List<Integer> digits, int digitPosition) {
        if (!isZeroAfterSecondDigit(digits, str, digitPosition)) {
            addSpacingBetweenWords(digits.size(), str, digitPosition);
            str.append(convertSingleDigit(digits.get(digitPosition)));
        }
    }

    private void addSecondDigitWords(List<Integer> digits, StringBuilder str, int digitPosition) {
        if (isTeenNumber(digits)) {
            addTeenDigitWords(str, digits);
        } else if (!isZeroDigit(digits, digitPosition)) {
            addTensDigitWords(digits, str, digitPosition);
        }
    }

    private boolean isZeroDigit(List<Integer> digits, int digitPosition) {
        return digits.get(digitPosition) == 0;
    }

    private void addTensDigitWords(List<Integer> digits, StringBuilder str, int digitPosition) {
        addSpacingBetweenWords(digits.size(), str, digitPosition);
        str.append(convertDoubleDigit(digits.get(digitPosition)));
    }

    private void addSpacingBetweenWords(int digitsSize, StringBuilder str, int digitPosition) {
        if (digitPosition != digitsSize - 1) {
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
            case 0:
                return NumberWords.TEN;
            case 1:
                return NumberWords.ELEVEN;
            case 2:
                return NumberWords.TWELVE;
            case 3:
                return NumberWords.THIRTEEN;
            case 4:
                return NumberWords.FOURTEEN;
            case 5:
                return NumberWords.FIFTEEN;
            case 6:
                return NumberWords.SIXTEEN;
            case 7:
                return NumberWords.SEVENTEEN;
            case 8:
                return NumberWords.EIGHTEEN;
            case 9:
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
        int length = (int) (Math.log10(number) + 1);
        return number == 0 ? 1 : length;
    }
}
