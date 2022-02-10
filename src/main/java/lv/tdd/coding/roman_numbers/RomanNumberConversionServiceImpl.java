package lv.tdd.coding.roman_numbers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.tdd.coding.roman_numbers.vo.Numbers;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class RomanNumberConversionServiceImpl implements RomanNumberConversionService {

    private final static String NIL = "0";

    private final YearValidationService validationService;

    @Override
    public String convertToRoman(String arabic) {
        if (!validationService.isValid(arabic)) {
            return null;
        }
        return convert(arabic);
    }

    String convert(String arabic) {
        if (arabic.equals(NIL)) {
            return NIL;
        }
        List<Numbers> numbers = revertToNumbers(arabic);
        return buildRomanString(numbers);
    }

    List<Numbers> revertToNumbers(String arabic) {
        return StringUtils.reverse(arabic).chars()
                                 .mapToObj(symbol -> (char) symbol)
                                 .map(eachArabic -> Numbers.fromArabic(eachArabic.toString()))
                                 .collect(Collectors.toList());
    }

    private String buildRomanString(List<Numbers> numbers) {
        if (numbers.size() == 1) {
            return numbers.get(0).getOnes();
        } else if (numbers.size() == 2) {
            return numbers.get(1).getTens() + numbers.get(0).getOnes();
        } else if (numbers.size() == 3) {
            return numbers.get(2).getHundreds() + numbers.get(1).getTens() + numbers.get(0).getOnes();
        } else if (numbers.size() == 4) {
            return numbers.get(3).getThousands() + numbers.get(2).getHundreds() + numbers.get(1).getTens() + numbers.get(0).getOnes();
        } else {
            return "BC "+ numbers.get(3).getThousands() + numbers.get(2).getHundreds() + numbers.get(1).getTens() + numbers.get(0).getOnes();
        }
    }
}
