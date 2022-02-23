package lv.tdd.coding.card_payments.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private int amount;
    private String firstname;
    private String lastname;
    private String pan;
    private String cvc;
    private String country;
    private String paymentProviderCode;
}
