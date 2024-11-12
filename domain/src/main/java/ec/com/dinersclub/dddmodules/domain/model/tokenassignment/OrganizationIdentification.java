package ec.com.dinersclub.dddmodules.domain.model.tokenassignment;

import ec.com.dinersclub.validador.anotacion.LongitudValidator;
import ec.com.dinersclub.validador.anotacion.NotNullValidator;
import ec.com.dinersclub.validador.order.Level1;
import ec.com.dinersclub.validador.order.Level2;
import ec.com.dinersclub.validador.order.Level3;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.GroupSequence;

import java.io.Serializable;

@RegisterForReflection
@GroupSequence({ OrganizationIdentification.class, Level1.class, Level2.class, Level3.class })
public class OrganizationIdentification implements Serializable {

    private static final long serialVersionUID = -5544362063112498715L;

    @NotNullValidator(message = "El identificador del banco es requerido.", code = "0002", groups = Level1.class)
    @LongitudValidator(message = "La longitud del identificador del banco es de 2 caracteres.", code = "0003", longitud = 2, groups = Level2.class)
    private String bankIdentificationNumber;

    public String getBankIdentificationNumber() {
        return bankIdentificationNumber;
    }

    public void setBankIdentificationNumber(String bankIdentificationNumber) {
        this.bankIdentificationNumber = bankIdentificationNumber;
    }
}
