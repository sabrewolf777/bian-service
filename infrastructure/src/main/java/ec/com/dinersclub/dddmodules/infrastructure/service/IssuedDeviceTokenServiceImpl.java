package ec.com.dinersclub.dddmodules.infrastructure.service;

import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyRequestCardDetail;
import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyRequestCardUpdate;
import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyResponseCardDetail;
import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyResponseCardExpDetail;
import ec.com.dinersclub.dddmodules.domain.repository.IIssuedDeviceTokenRepository;
import ec.com.dinersclub.dddmodules.infrastructure.repository.IssuedDeviceTokenRepository;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ResponseMs;
import ec.com.dinersclub.excepciones.interfaces.AbstractMsExcepcion;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class IssuedDeviceTokenServiceImpl implements IIssuedDeviceTokenRepository {

    @Inject
    IssuedDeviceTokenRepository cardRepository;


    @Override
    public ResponseMs updateCardToken(RequestMs<DinBodyRequestCardUpdate> command) throws AbstractMsExcepcion, IllegalAccessException {
        ResponseMs responseMs = new ResponseMs<>(command.getDinHeader());
        RequestMs<DinBodyRequestCardDetail> requestCard = new RequestMs<>();
        requestCard.setDinHeader(command.getDinHeader());
        requestCard.setDinBody(new DinBodyRequestCardDetail());
        requestCard.getDinBody().setPaymentCard(command.getDinBody().getPaymentCard());
        requestCard.getDinBody().setOrganizationIdentification(command.getDinBody().getOrganizationIdentification());
        DinBodyResponseCardDetail cardDetail = cardRepository.getCardToken(requestCard);
        DinBodyResponseCardExpDetail expCard = cardRepository.updatetCardToken(requestCard);
        responseMs.setDinBody(expCard);
        return responseMs;
    }
}
