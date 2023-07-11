package com.matheusiam.crudspring.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusiam.crudspring.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRC {
	@Autowired
	private UsuarioService service;
}
