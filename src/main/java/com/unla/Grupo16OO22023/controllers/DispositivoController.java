package com.unla.Grupo16OO22023.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.Grupo16OO22023.helpers.ViewRouteHelper;

@Controller
@PreAuthorize("hasRole('ROLE_1')")
@RequestMapping("/dispositivos")
public class DispositivoController {
	

	@GetMapping("/listadodispositivos")
	public String crear() {
		return ViewRouteHelper.DISP_LISTADO;
	}

}
