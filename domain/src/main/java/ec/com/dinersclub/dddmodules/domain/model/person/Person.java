package ec.com.dinersclub.dddmodules.domain.model.person;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class Person implements Serializable {

    private static final long serialVersionUID = 5626099635035213081L;
    private PersonName personName;
    private String cedula;

    public PersonName getPersonName() {
        return personName;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
