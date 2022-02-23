package lv.tdd.coding.card_payments;

import lv.tdd.coding.card_payments.vo.PaymentRequest;
import lv.tdd.coding.card_payments.vo.PaymentResponse;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

    PaymentService service = new PaymentServiceImpl();

    @Test
    void shouldAffectPayment() {
        PaymentResponse response = service.makePayment(new PaymentRequest(
                200,
                "John",
                "Doe",
                "12345",
                "123",
                "LV",
                "Klix"));
        response.getPaymentStats();
    }
}
