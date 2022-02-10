package lv.tdd.coding.roman_numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YearValidationServiceTest {

    YearValidationService validationService = new YearValidationService();

    @Test
    void shouldValidateCorrectYear() {
        String correctPositiveYear = "4999";
        String correctNegativeYear = "-4999";

        assertThat(validationService.isValid(correctPositiveYear)).isTrue();
        assertThat(validationService.isValid(correctNegativeYear)).isTrue();
    }

    @Test
    void shouldFailToValidateIncorrectInput() {
        String stringValue = "abc";
        String excessiveNegativeYear = "-5000";

        assertThat(validationService.isValid(stringValue)).isFalse();
        assertThat(validationService.isValid(excessiveNegativeYear)).isFalse();
    }

    @Test
    void shouldIsIntegerReturnFalse_IfNotInteger() {
        String floatValue = "123.0";
        String stringValue = "abc";
        String blankValue = "";
        String nullValue = null;
        String veryLongValue = "12345678901234567890";

        assertThat(validationService.isInteger(floatValue)).isFalse();
        assertThat(validationService.isInteger(stringValue)).isFalse();
        assertThat(validationService.isInteger(blankValue)).isFalse();
        assertThat(validationService.isInteger(nullValue)).isFalse();
        assertThat(validationService.isInteger(veryLongValue)).isFalse();
    }

    @Test
    void shouldIsIntegerReturnTrue_IfInteger() {
        String correctPositiveYear = "1250";
        String correctNegativeYear = "-1250";

        assertThat(validationService.isInteger(correctPositiveYear)).isTrue();
        assertThat(validationService.isInteger(correctNegativeYear)).isTrue();
    }

    @Test
    void shouldHaveAllowedSize() {
        String correctPositiveYear = "10";
        String correctNegativeYear = "-1250";

        assertThat(validationService.hasAllowedSize(correctPositiveYear)).isTrue();
        assertThat(validationService.hasAllowedSize(correctNegativeYear)).isTrue();
    }

    @Test
    void shouldNotHaveAllowedSize() {
        String excessivePositiveYear = "1000000";
        String excessiveNegativeYear = "-12500";

        assertThat(validationService.hasAllowedSize(excessivePositiveYear)).isFalse();
        assertThat(validationService.hasAllowedSize(excessiveNegativeYear)).isFalse();
    }
}
