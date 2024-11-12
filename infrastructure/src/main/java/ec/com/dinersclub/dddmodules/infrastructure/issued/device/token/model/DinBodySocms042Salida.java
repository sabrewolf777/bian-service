package ec.com.dinersclub.dddmodules.infrastructure.issued.device.token.model;

import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyResponseCardDetail;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

@RegisterForReflection
public class DinBodySocms042Salida implements Serializable {

    private static final long serialVersionUID = 4966474680503871220L;
    private DinBodyResponseCardDetail cardDetail;
    private String errorCode;
    private String descriptionError;

    public DinBodyResponseCardDetail getCardDetail() {
        return cardDetail;
    }

    public void setCardDetail(DinBodyResponseCardDetail cardDetail) {
        this.cardDetail = cardDetail;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }
}
