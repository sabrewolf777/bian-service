package ec.com.dinersclub.dddmodules.infrastructure.issued.device.token.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class Socms043Entrada implements Serializable {

    private static final long serialVersionUID = 4758180157686470143L;
    private String entidad;
    private String cardBrand;
    private String cardNumber;

    public String getEntidad() {
        return entidad;
    }

    @JsonSetter("P0ENTI")
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    @JsonSetter("P0MARC")
    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @JsonSetter("P0TARJ")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
