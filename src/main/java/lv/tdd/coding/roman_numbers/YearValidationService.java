package lv.tdd.coding.roman_numbers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static lv.tdd.coding.roman_numbers.Settings.MAX_ABS_YEAR;

@Slf4j
@Service
public class YearValidationService {

    public boolean isValid(String arabic) {
        return isInteger(arabic) && hasAllowedSize(arabic);
    }

    boolean isInteger(String arabic) {
        try {
            Integer.parseInt(arabic);
        } catch (NumberFormatException e) {
            log.error("Not a number: {}", arabic);
            return false;
        }
        return true;
    }

    boolean hasAllowedSize(String arabic) {
        return Math.abs(Integer.parseInt(arabic)) <= MAX_ABS_YEAR;
    }
}
