package lv.tdd.coding.roman_numbers.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Numbers {

    ZERO("0", "", "" , "" , ""),
    ONE("1", "I", "X", "C", "M"),
    TWO("2", "II", "XX", "CC", "MM"),
    THREE("3", "III", "XXX", "CCC", "MMM"),
    FOUR("4", "IV", "XL", "CD", "MMMM"),
    FIVE("5", "V", "L", "D", ""),
    SIX("6", "VI", "LX", "DC", ""),
    SEVEN("7", "VII", "LXX", "DCC", ""),
    EIGHT("8", "VIII", "LXXX", "DCCC", ""),
    NINE("9", "IX", "XC", "CM", ""),
    MINUS("-", "BC ", "BC ", "BC ", "BC ");

    private String arabicDigit;

    private String ones;

    private String tens;

    private String hundreds;

    private String thousands;

    public static Numbers fromArabic(String digit) {
        for (Numbers numbers : Numbers.values()) {
            if (numbers.arabicDigit.equals(digit)) {
                return numbers;
            }
        }
        return null;
    }
}
