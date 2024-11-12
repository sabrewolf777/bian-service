package com.mx.bianservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.bianservice.service.VersionService;
import com.mx.bianservice.to.ResponseVersion;

@RestController
@RequestMapping("/api/version")
public class VersionController {

	@Autowired
	VersionService service;
	
	@GetMapping
	public ResponseEntity<ResponseVersion> getVersion(){
		
		return new ResponseEntity<>(service.getVersion(),HttpStatus.OK);
	}
	
	
}
