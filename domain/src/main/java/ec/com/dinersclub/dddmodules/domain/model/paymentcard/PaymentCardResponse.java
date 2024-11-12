package ec.com.dinersclub.dddmodules.domain.model.paymentcard;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class PaymentCardResponse implements Serializable {

    private static final long serialVersionUID = -1319058682914144986L;
    private String cardExpiryDate;
    private String cardStartDate;

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardStartDate() {
        return cardStartDate;
    }

    public void setCardStartDate(String cardStartDate) {
        this.cardStartDate = cardStartDate;
    }

}
