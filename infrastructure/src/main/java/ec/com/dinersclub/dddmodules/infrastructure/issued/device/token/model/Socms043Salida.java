package ec.com.dinersclub.dddmodules.infrastructure.issued.device.token.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class Socms043Salida implements Serializable {

    private static final long serialVersionUID = -8500148484875325902L;
    private String fromDate;
    private String expiryDate;
    private String errorCode;
    private String descriptionError;

    public String getFromDate() {
        return fromDate;
    }

    @JsonSetter("P0VIGD")
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @JsonSetter("P0VIGA")
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @JsonSetter("P0CODE")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    @JsonSetter("P0DESE")
    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }
}
