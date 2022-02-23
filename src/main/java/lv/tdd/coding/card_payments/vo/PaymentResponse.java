package lv.tdd.coding.card_payments.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    PaymentStatus paymentStatus;
    String description;

    public void getPaymentStats() {
        System.out.println("----------------------------------");
        System.out.println("Payment status : " + paymentStatus);
        System.out.println(description);
        System.out.println();
    }
}
