package com.mx.bianservice.to;

import java.util.Date;
import lombok.Data;

@Data
public class ResponseVersion {
	private MensajeResponse response;
	private String release; 
	private long version;
	private Date fecha;
}
