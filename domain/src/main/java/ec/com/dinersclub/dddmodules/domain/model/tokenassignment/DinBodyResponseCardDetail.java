package ec.com.dinersclub.dddmodules.domain.model.tokenassignment;

import ec.com.dinersclub.dddmodules.domain.model.account.Account;
import ec.com.dinersclub.dddmodules.domain.model.device.Device;
import ec.com.dinersclub.dddmodules.domain.model.paymentcard.PaymentCardResponse;
import ec.com.dinersclub.dddmodules.domain.model.person.Person;
import ec.com.dinersclub.dddmodules.domain.model.product.Product;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodyResponseCardDetail implements Serializable {

    private static final long serialVersionUID = 7629111627475363721L;
    private Person person;
    private Product product;
    private PaymentCardResponse paymentCard;
    private Device device;
    private Account account;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PaymentCardResponse getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCardResponse paymentCard) {
        this.paymentCard = paymentCard;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
