package lv.tdd.coding.roman_numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumberConversionServiceTest {

    YearValidationService validationService = new YearValidationService();
    RomanNumberConversionService conversionService = new RomanNumberConversionServiceImpl(validationService);

    @Test
    void shouldReturnNullIfNotValidInput() {
        String stringValue = "1v50";

        assertThat(conversionService.convertToRoman(stringValue)).isNull();
    }

    @Test
    void shouldReturnTRUEIfValidInput() {
        String validValue = "1150";

        assertThat(conversionService.convertToRoman(validValue)).isNotEmpty();
    }

    @Test
    void shouldReturnNilIfInputValueNil() {
        String validValue = "0";

        assertThat(conversionService.convertToRoman(validValue)).isEqualTo("0");
    }

    @Test
    void shouldConvertValidArabicToRoman() {
        String valid_1 = "1234";
        String valid_2 = "40";
        String valid_3 = "-940";
        String valid_4 = (Settings.MAX_ABS_YEAR * (-1)) + "";

        assertThat(conversionService.convertToRoman(valid_1)).isEqualTo("MCCXXXIV");
        assertThat(conversionService.convertToRoman(valid_2)).isEqualTo("XL");
        assertThat(conversionService.convertToRoman(valid_3)).isEqualTo("BC CMXL");
        assertThat(conversionService.convertToRoman(valid_4)).isEqualTo("BC MMMMCMXCIX");
    }
}
