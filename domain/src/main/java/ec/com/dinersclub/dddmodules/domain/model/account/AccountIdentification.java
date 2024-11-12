package ec.com.dinersclub.dddmodules.domain.model.account;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class AccountIdentification implements Serializable {

    private static final long serialVersionUID = 8801646218012469829L;
    private String accountIdentification;
    private String accountIdentificationType;

    public String getAccountIdentification() {
        return accountIdentification;
    }

    public void setAccountIdentification(String accountIdentification) {
        this.accountIdentification = accountIdentification;
    }

    public String getAccountIdentificationType() {
        return accountIdentificationType;
    }

    public void setAccountIdentificationType(String accountIdentificationType) {
        this.accountIdentificationType = accountIdentificationType;
    }
}
