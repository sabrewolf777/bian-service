package ec.com.dinersclub.dddmodules.infrastructure.issued.device.token.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class Socms042Salida implements Serializable {

    private static final long serialVersionUID = -8816579217432836492L;
    private String cedula;
    private String givenName;
    private String secondName;
    private String middleName;
    private String lastName;
    private String accountIdentification;
    private String cardNumber;
    private String cancelationCode;
    private String descriptionCancelationCode;
    private String boletinCode;
    private String descriptionBoletinCode;
    private String cardExpiryDate;
    private String productName;
    private String productDescription;
    private String nameInCard;

    private String numberValidityMonths;
    private String numberValidityYears;

    public String getCedula() {
        return cedula;
    }

    @JsonSetter("P0CEDULA")
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getGivenName() {
        return givenName;
    }

    @JsonSetter("P0PRINOM")
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSecondName() {
        return secondName;
    }

    @JsonSetter("P0SEGNOM")
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @JsonSetter("P0APEPAT")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonSetter("P0APEMAT")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountIdentification() {
        return accountIdentification;
    }

    @JsonSetter("P0CUENTA")
    public void setAccountIdentification(String accountIdentification) {
        this.accountIdentification = accountIdentification;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @JsonSetter("P0TARJET")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCancelationCode() {
        return cancelationCode;
    }

    @JsonSetter("P0CODRET")
    public void setCancelationCode(String cancelationCode) {
        this.cancelationCode = cancelationCode;
    }

    public String getDescriptionCancelationCode() {
        return descriptionCancelationCode;
    }

    @JsonSetter("P0DESRET")
    public void setDescriptionCancelationCode(String descriptionCancelationCode) {
        this.descriptionCancelationCode = descriptionCancelationCode;
    }

    public String getBoletinCode() {
        return boletinCode;
    }

    @JsonSetter("P0BOLNAC")
    public void setBoletinCode(String boletinCode) {
        this.boletinCode = boletinCode;
    }

    public String getDescriptionBoletinCode() {
        return descriptionBoletinCode;
    }

    @JsonSetter("P0DESBOL")
    public void setDescriptionBoletinCode(String descriptionBoletinCode) {
        this.descriptionBoletinCode = descriptionBoletinCode;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    @JsonSetter("P0FECVIG")
    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getProductName() {
        return productName;
    }

    @JsonSetter("P0CDPROD")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    @JsonSetter("P0DESPRO")
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getNameInCard() {
        return nameInCard;
    }

    @JsonSetter("P0NOMPLAS")
    public void setNameInCard(String nameInCard) {
        this.nameInCard = nameInCard;
    }

    public String getNumberValidityMonths() {
        return numberValidityMonths;
    }

    @JsonSetter("P0NROMEV")
    public void setNumberValidityMonths(String numberValidityMonths) {
        this.numberValidityMonths = numberValidityMonths;
    }

    public String getNumberValidityYears() {
        return numberValidityYears;
    }
    @JsonSetter("P0NROAVIG")
    public void setNumberValidityYears(String numberValidityYears) {
        this.numberValidityYears = numberValidityYears;
    }
}
