package ec.com.dinersclub.dddmodules.domain.model.device;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class Device implements Serializable {

    private static final long serialVersionUID = 63020473784113108L;
    private String cancelationCode;
    private String descriptionCancelationCode;
    private String boletinCode;
    private String descriptionBoletinCode;

    public String getCancelationCode() {
        return cancelationCode;
    }

    public void setCancelationCode(String cancelationCode) {
        this.cancelationCode = cancelationCode;
    }

    public String getDescriptionCancelationCode() {
        return descriptionCancelationCode;
    }

    public void setDescriptionCancelationCode(String descriptionCancelationCode) {
        this.descriptionCancelationCode = descriptionCancelationCode;
    }

    public String getBoletinCode() {
        return boletinCode;
    }

    public void setBoletinCode(String boletinCode) {
        this.boletinCode = boletinCode;
    }

    public String getDescriptionBoletinCode() {
        return descriptionBoletinCode;
    }

    public void setDescriptionBoletinCode(String descriptionBoletinCode) {
        this.descriptionBoletinCode = descriptionBoletinCode;
    }
}
