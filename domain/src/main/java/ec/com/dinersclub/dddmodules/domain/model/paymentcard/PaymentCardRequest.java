package ec.com.dinersclub.dddmodules.domain.model.paymentcard;

import ec.com.dinersclub.validador.anotacion.LongitudValidator;
import ec.com.dinersclub.validador.anotacion.NotNullValidator;
import ec.com.dinersclub.validador.order.Level1;
import ec.com.dinersclub.validador.order.Level2;
import ec.com.dinersclub.validador.order.Level3;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.GroupSequence;

import java.io.Serializable;

@RegisterForReflection
@GroupSequence({ PaymentCardRequest.class, Level1.class, Level2.class, Level3.class })
public class PaymentCardRequest implements Serializable {

    private static final long serialVersionUID = 7167587347183811319L;
    @NotNullValidator(message = "El número de tarjeta es requerida.", code = "0002", groups = Level1.class)
    private String cardNumber;

    @NotNullValidator(message = "La marca de la tarjeta es requerida.", code = "0002", groups = Level1.class)
    @LongitudValidator(message = "La longitud de la marca de la tarjeta es de 2 caracteres.", code = "0003", longitud = 2, groups = Level2.class)
    private String cardBrand;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

}