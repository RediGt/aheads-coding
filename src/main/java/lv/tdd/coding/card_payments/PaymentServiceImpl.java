package lv.tdd.coding.card_payments;

import lv.tdd.coding.card_payments.vo.PaymentProvider;
import lv.tdd.coding.card_payments.vo.PaymentRequest;
import lv.tdd.coding.card_payments.vo.PaymentResponse;
import org.springframework.stereotype.Service;

import static lv.tdd.coding.card_payments.vo.PaymentStatus.ERROR;
import static lv.tdd.coding.card_payments.vo.PaymentStatus.INCORRECT_DATA;
import static lv.tdd.coding.card_payments.vo.PaymentStatus.SUCCESS;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResponse makePayment(PaymentRequest request) {
        PaymentProvider provider = PaymentProvider.fromName(request.getPaymentProviderCode());
        if (provider == PaymentProvider.UNKNOWN) {
            return new PaymentResponse(INCORRECT_DATA, "Payment cancelled. No such provider.");
        }
        return contactProvider(provider, request);
    }

    private PaymentResponse contactProvider(PaymentProvider provider, PaymentRequest request) {
        if (provider == PaymentProvider.KLIX && request.getAmount() > PaymentProvider.KLIX.getPaymentUpperLimit()) {
            return new PaymentResponse(ERROR, "PAYMENT_TYPE: KLIX, max payment limit exceeded.");
        }
        int withFee = request.getAmount() * (1 + provider.getFeePercent());
        return new PaymentResponse(SUCCESS, "Paid: " + withFee + ", through: " + provider.getName());
    }
}
