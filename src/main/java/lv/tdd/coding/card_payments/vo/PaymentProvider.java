package lv.tdd.coding.card_payments.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor
public enum PaymentProvider {

    AMERICAN_EXPRESS("American Express", 0, -1),
    MASTERCARD("Mastercard", 0, -1),
    KLIX("Klix", 0, 100),
    PAY_PAL("Paypal", 15, -1),
    VISA("Visa", 0, -1),
    UNKNOWN("", -1, -1);

    private final String name;
    private final int feePercent;
    private final int paymentUpperLimit;

    public static PaymentProvider fromName(String name) {
        if (StringUtils.isBlank(name)) {
            return UNKNOWN;
        }

        for (PaymentProvider provider : PaymentProvider.values()) {
            if (provider.getName().equals(name)) {
                return provider;
            }
        }
        return UNKNOWN;
    }
}
