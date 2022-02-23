package lv.tdd.coding.card_payments;

import lv.tdd.coding.card_payments.vo.PaymentRequest;
import lv.tdd.coding.card_payments.vo.PaymentResponse;

public interface PaymentService {

   PaymentResponse makePayment(PaymentRequest request);
}
