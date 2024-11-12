package ec.com.dinersclub.dddmodules.domain.model.tokenassignment;

import ec.com.dinersclub.dddmodules.domain.model.paymentcard.PaymentCardRequest;
import ec.com.dinersclub.validador.anotacion.ObjectValidator;
import ec.com.dinersclub.validador.order.Level1;
import ec.com.dinersclub.validador.order.Level2;
import ec.com.dinersclub.validador.order.Level3;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.GroupSequence;

import java.io.Serializable;

@RegisterForReflection
@GroupSequence({ DinBodyRequestCardUpdate.class, Level1.class, Level2.class, Level3.class })
public class DinBodyRequestCardUpdate implements Serializable {

    private static final long serialVersionUID = -3075476468973639868L;
    @ObjectValidator(message = "El campo tarjeta de pago es requerido.", code = "0002", groups = Level1.class)
    private PaymentCardRequest paymentCard;
    @ObjectValidator(message = "El identificador de banco es requerido.", code = "0002", groups = Level1.class)
    private OrganizationIdentification organizationIdentification;

    public PaymentCardRequest getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCardRequest paymentCard) {
        this.paymentCard = paymentCard;
    }

    public OrganizationIdentification getOrganizationIdentification() {
        return organizationIdentification;
    }

    public void setOrganizationIdentification(OrganizationIdentification organizationIdentification) {
        this.organizationIdentification = organizationIdentification;
    }
}
