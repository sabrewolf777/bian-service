package ec.com.dinersclub.dddmodules.domain.repository;

import ec.com.dinersclub.dddmodules.domain.model.tokenassignment.DinBodyRequestCardUpdate;
import ec.com.dinersclub.dto.RequestMs;
import ec.com.dinersclub.dto.ResponseMs;
import ec.com.dinersclub.excepciones.interfaces.AbstractMsExcepcion;

public interface IIssuedDeviceTokenRepository {


    ResponseMs updateCardToken(
            RequestMs<DinBodyRequestCardUpdate> command) throws AbstractMsExcepcion, IllegalAccessException;
}
