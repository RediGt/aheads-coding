package lv.tdd.coding.roman_numbers;

import lv.tdd.coding.roman_numbers.vo.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumberConversionServiceImplTest {

    YearValidationService validationService = new YearValidationService();
    RomanNumberConversionServiceImpl conversionService = new RomanNumberConversionServiceImpl(validationService);

    @Test
    void shouldConvertValidArabicToRoman() {
        String stringValue = "1234";

        assertThat(conversionService.convert(stringValue)).isEqualTo("MCCXXXIV");
    }

    @Test
    void shouldRevertArabicStringToNumbersList() {
        String validValue = "1150";
        String validNegativeValue = "-100";

        assertThat(conversionService.revertToNumbers(validValue)).containsExactly(Numbers.ZERO, Numbers.FIVE, Numbers.ONE, Numbers.ONE);
        assertThat(conversionService.revertToNumbers(validNegativeValue)).containsExactly(Numbers.ZERO, Numbers.ZERO, Numbers.ONE, Numbers.MINUS);
    }
}
