package ec.com.dinersclub.dddmodules.infrastructure.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.dinersclub.dto.IDinError;
import ec.com.dinersclub.dto.ResponseAS400;
import ec.com.dinersclub.excepciones.MicroservicioError;
import ec.com.dinersclub.excepciones.MicroservicioExcepcion;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import java.io.ByteArrayInputStream;

public class IssuedDevAdminMapper implements ResponseExceptionMapper<RuntimeException> {
    private ObjectMapper mapper;

    public IssuedDevAdminMapper() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public RuntimeException toThrowable(Response response) {

        int status = response.getStatus();
        String reason = response.getStatusInfo().getReasonPhrase();

        String msgJson = getBody(response);

        switch (status) {

            case 400:
                return new MicroservicioError(this.obtenerDinError(msgJson));

            case 500:
                return new MicroservicioExcepcion(this.obtenerDinError(msgJson));

            default:
                return new MicroservicioExcepcion(null, null, reason, reason);
        }
    }

    private static String getBody(Response response) {

        if (response.getEntity() instanceof ByteArrayInputStream) {
            ByteArrayInputStream is = (ByteArrayInputStream) response.getEntity();
            byte[] bytes = new byte[is.available()];
            is.read(bytes, 0, is.available());
            return new String(bytes);
        }

        return null;
    }

    private IDinError obtenerDinError(String msgJson) {

        try {

            return mapper.readValue(msgJson, new TypeReference<ResponseAS400<Object>>() {
            }).getDinError();

        } catch (JsonProcessingException e) {
            throw new MicroservicioExcepcion(e, "Obtener DinError AS400 GESTOR");
        }

    }
}
