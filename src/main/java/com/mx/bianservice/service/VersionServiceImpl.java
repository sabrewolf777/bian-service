package com.mx.bianservice.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import com.mx.bianservice.to.MensajeResponse;
import com.mx.bianservice.to.ResponseVersion;

@Service
public class VersionServiceImpl implements VersionService{

	@Override
	public ResponseVersion getVersion() {
	
		ResponseVersion response= new ResponseVersion();
		MensajeResponse mensaje= new MensajeResponse();
		
		mensaje.setCodigo(200);
		mensaje.setMensaje("se obtuvo la version correctamente");
		
		response.setFecha(new Date());
		response.setResponse(mensaje);
		response.setRelease("1.001");
		response.setVersion(1);
		return response;
	}

}
