package ec.com.dinersclub.dddmodules.domain.model.product;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class Product implements Serializable {
    private static final long serialVersionUID = 8164362479996341224L;
    private String name;
    private String description;
    private String numberValidityYears;
    private String numberValidityMonths;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberValidityYears() {
        return numberValidityYears;
    }

    public void setNumberValidityYears(String numberValidityYears) {
        this.numberValidityYears = numberValidityYears;
    }

    public String getNumberValidityMonths() {
        return numberValidityMonths;
    }

    public void setNumberValidityMonths(String numberValidityMonths) {
        this.numberValidityMonths = numberValidityMonths;
    }
}
