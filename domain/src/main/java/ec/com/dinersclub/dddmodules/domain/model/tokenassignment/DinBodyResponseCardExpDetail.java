package ec.com.dinersclub.dddmodules.domain.model.tokenassignment;

import ec.com.dinersclub.dddmodules.domain.model.paymentcard.PaymentCardResponse;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyResponseCardExpDetail implements Serializable {

    private static final long serialVersionUID = 7862076411542074424L;
    private PaymentCardResponse paymentCard;

    public PaymentCardResponse getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCardResponse paymentCard) {
        this.paymentCard = paymentCard;
    }
}
