package ec.com.dinersclub.dddmodules.infrastructure.proxy;

import ec.com.dinersclub.dddmodules.infrastructure.providers.IssuedDevAdminMapper;
import ec.com.dinersclub.dto.RequestMs;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/issued-device-administration/token-assignment")
@RegisterProvider(value = IssuedDevAdminMapper.class, priority = 50)
@RegisterRestClient(configKey = "servicio-issdevadm")
public interface IssuedDevAdminTokProxy {
    @POST
    @PermitAll
    @Path("/retrieve")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response retrieveToken(RequestMs request);

}
