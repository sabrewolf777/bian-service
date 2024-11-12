package ec.com.dinersclub.dddmodules.domain.model.account;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class Account implements Serializable {

    private static final long serialVersionUID = 8015639027348943390L;

    private AccountIdentification accountIdentification;

    public AccountIdentification getAccountIdentification() {
        return accountIdentification;
    }

    public void setAccountIdentification(AccountIdentification accountIdentification) {
        this.accountIdentification = accountIdentification;
    }
}
