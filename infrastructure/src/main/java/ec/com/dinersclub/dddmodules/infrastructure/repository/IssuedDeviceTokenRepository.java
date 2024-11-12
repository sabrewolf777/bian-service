package ec.com.dinersclub.dddmodules.infrastructure.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.TokenRequest;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.TokenResponse;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.ServiciosTokenGrpc;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.PaymentCardRequest;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.OrganizationIdentification;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.BodyRequestToken;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.Header;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.PaginadoHeader;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.TokenUpdateRequest;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.TokenUpdateResponse;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.BodyRequestUpdateToken;
import ec.com.dinersclub.dddmodules.application.grpc.tokenassign.Error;
import ec.com.dinersclub.dddmodules.domain.model.account.Account;
import ec.com.dinersclub.dddmodules.domain.model.account.AccountIdentification;
import ec.com.dinersclub.dddmodules.domain.model.device.Device;
import ec.com.dinersclub.dddmodules.domain.model.paymentcard.PaymentCardResponse;
import ec.com.dinersclub.dddmodules.domain.model.person.Person;
import ec.com.dinersclub.dddmodules.domain.model.person.PersonName;
import ec.com.dinersclub.dddmodules.domain.model.product.Product;
import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyRequestCardDetail;
import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyResponseCardDetail;
import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyResponseCardExpDetail;
import ec.com.dinersclub.dddmodules.infrastructure.propiedades.ConfiguracionProperties;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ErrorMs;
import ec.com.dinersclub.excepciones.MicroservicioError;
import ec.com.dinersclub.excepciones.MicroservicioExcepcion;
import ec.com.dinersclub.excepciones.interfaces.AbstractMsExcepcion;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class IssuedDeviceTokenRepository {

    @Inject
    @GrpcClient("servicio-issdevadm")
    ServiciosTokenGrpc.ServiciosTokenBlockingStub detailToken;

    private final ObjectMapper mapper;

    @Inject
    ConfiguracionProperties configProperties;

    public IssuedDeviceTokenRepository() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public DinBodyResponseCardDetail getCardToken(RequestMs<DinBodyRequestCardDetail> command)
            throws AbstractMsExcepcion {

        TokenRequest.Builder cardDetail = invokeIussed(command);
        TokenRequest tokenRe = cardDetail.build();
        TokenResponse resultado = detailToken.getCardDetailToken(tokenRe);

        if(!resultado.getDinError().getCodigo().isBlank()){
            throw new MicroservicioError(
                    this.obtenerErrorDatosResponse(resultado.getDinError()));
        }

        DinBodyResponseCardDetail response = new DinBodyResponseCardDetail();
        Account account = new Account();
        account.setAccountIdentification(new AccountIdentification());
        account.getAccountIdentification().setAccountIdentification(resultado.getDinBody().getAccount().getAccountIdentification().getAccountIdentification());
        response.setAccount(account);
        response.setDevice(new Device());
        response.getDevice().setDescriptionBoletinCode(resultado.getDinBody().getDevice().getDescriptionBoletinCode());
        response.getDevice().setBoletinCode(resultado.getDinBody().getDevice().getBoletinCode());
        response.getDevice().setDescriptionCancelationCode(resultado.getDinBody().getDevice().getDescriptionCancelationCode());
        response.getDevice().setCancelationCode(resultado.getDinBody().getDevice().getCancelationCode());
        response.setProduct(new Product());
        response.getProduct().setNumberValidityMonths(resultado.getDinBody().getProduct().getNumberValidityMonths());
        response.getProduct().setDescription(resultado.getDinBody().getProduct().getDescription());
        response.getProduct().setName(resultado.getDinBody().getProduct().getName());
        response.getProduct().setNumberValidityYears(resultado.getDinBody().getProduct().getNumberValidityYears());
        response.setPerson(new Person());
        response.getPerson().setCedula(resultado.getDinBody().getPerson().getCedula());
        response.getPerson().setPersonName(new PersonName());
        response.getPerson().getPersonName().setLastName(resultado.getDinBody().getPerson().getPersonName().getLastName());
        response.getPerson().getPersonName().setMiddleName(resultado.getDinBody().getPerson().getPersonName().getMiddleName());
        response.getPerson().getPersonName().setSecondName(resultado.getDinBody().getPerson().getPersonName().getSecondName());
        response.getPerson().getPersonName().setGivenName(resultado.getDinBody().getPerson().getPersonName().getGivenName());
        response.setPaymentCard(new PaymentCardResponse());
        response.getPaymentCard().setCardExpiryDate(resultado.getDinBody().getPaymentCard().getCardExpiryDate());
        return response;
    }

    private TokenRequest.Builder invokeIussed(RequestMs<DinBodyRequestCardDetail> command){

        TokenRequest.Builder noftifi = TokenRequest.newBuilder();
        noftifi.setDinHeader(armarHeaderRequest(command));
        PaymentCardRequest paymentCard = PaymentCardRequest.newBuilder().setCardBrand(command.getDinBody().getPaymentCard().getCardBrand())
                        .setCardNumber(command.getDinBody().getPaymentCard().getCardNumber()).build();
        OrganizationIdentification organizationIden = OrganizationIdentification.newBuilder()
                .setBankIdentificationNumber(command.getDinBody().getOrganizationIdentification().getBankIdentificationNumber())
                        .build();
        noftifi.setDinBody(BodyRequestToken.newBuilder()
                        .setPaymentCard(paymentCard)
                        .setOrganizationIdentification(organizationIden)
                .build());
        return noftifi;
    }

    private Header armarHeaderRequest(RequestMs command) {

        return Header.newBuilder()
                .setAplicacionId(this.validarStringNulos(command.getDinHeader().getAplicacionId()))
                .setCanalId(this.validarStringNulos(command.getDinHeader().getCanalId()))
                .setSesionId(this.validarStringNulos(command.getDinHeader().getSesionId()))
                .setDispositivo(this.validarStringNulos(command.getDinHeader().getDispositivo()))
                .setIdioma(this.validarStringNulos(command.getDinHeader().getIdioma()))
                .setPortalId(this.validarStringNulos(command.getDinHeader().getPortalId()))
                .setHoraTransaccion(this.validarStringNulos(command.getDinHeader().getHoraTransaccion()))
                .setIp(this.validarStringNulos(command.getDinHeader().getIp()))
                .setLlaveSimetrica(this.validarStringNulos(command.getDinHeader().getLlaveSimetrica()))
                .setUsuario(this.validarStringNulos(command.getDinHeader().getUsuario()))
                .setUuid(this.validarStringNulos(command.getDinHeader().getUuid()))
                .setPaginado(PaginadoHeader.newBuilder()
                        .setCantRegistros(999999)
                        .setNumPagActual(1)
                        .setNumTotalPag(1).build())
                .build();
    }

    private String validarStringNulos(String valor) {

        if (valor == null) {
            return "";
        }

        return valor.trim();
    }

    public DinBodyResponseCardExpDetail updatetCardToken(RequestMs<DinBodyRequestCardDetail> command)
            throws AbstractMsExcepcion {
        TokenUpdateRequest.Builder cardDetail = invokeUpdateIussed(command);
        TokenUpdateRequest tokenRe = cardDetail.build();
        try {
            TokenUpdateResponse resultado = detailToken.updateCardDetailToken(tokenRe);
            if(!resultado.getDinError().getCodigo().isBlank()){
                throw new MicroservicioError(
                        this.obtenerErrorDatosResponse(resultado.getDinError()));
            }else{
                DinBodyResponseCardExpDetail expCard = new DinBodyResponseCardExpDetail();
                expCard.setPaymentCard(new PaymentCardResponse());
                expCard.getPaymentCard().setCardStartDate(resultado.getDinBody().getCardStartDate());
                expCard.getPaymentCard().setCardExpiryDate(resultado.getDinBody().getCardExpiryDate());
                return expCard;
            }
        } catch (AbstractMsExcepcion e) {
            throw new MicroservicioError(e.getDinError());

        } catch (Exception e) {
            throw new MicroservicioExcepcion(e);
        }
    }

    private TokenUpdateRequest.Builder invokeUpdateIussed(RequestMs<DinBodyRequestCardDetail> command){

        TokenUpdateRequest.Builder noftifi = TokenUpdateRequest.newBuilder();
        noftifi.setDinHeader(armarHeaderRequest(command));
        PaymentCardRequest paymentCard = PaymentCardRequest.newBuilder().setCardBrand(command.getDinBody().getPaymentCard().getCardBrand())
                .setCardNumber(command.getDinBody().getPaymentCard().getCardNumber()).build();
        OrganizationIdentification organizationIden = OrganizationIdentification.newBuilder()
                .setBankIdentificationNumber(command.getDinBody().getOrganizationIdentification().getBankIdentificationNumber())
                .build();
        noftifi.setDinBody(BodyRequestUpdateToken.newBuilder()
                .setPaymentCard(paymentCard)
                .setOrganizationIdentification(organizationIden)
                .build());
        return noftifi;
    }

    private ErrorMs obtenerErrorDatosResponse(Error error) {

        ErrorMs dinError = new ErrorMs();
        dinError.setTipo(error.getTipo());
        dinError.setFecha(error.getFecha());
        dinError.setOrigen(this.validarStringNulos(error.getOrigen()));
        dinError.setCodigo(this.validarStringNulos(error.getCodigo()));
        dinError.setCodigoErrorProveedor(this.validarStringNulos(error.getCodigoErrorProveedor()));
        dinError.setMensaje(this.validarStringNulos(error.getMensaje()));
        dinError.setDetalle(this.validarStringNulos(error.getDetalle()));
        return dinError;
    }

}
