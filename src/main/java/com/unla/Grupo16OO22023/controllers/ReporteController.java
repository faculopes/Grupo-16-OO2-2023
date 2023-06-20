package com.unla.Grupo16OO22023.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo16OO22023.helpers.ViewRouteHelper;
import com.unla.Grupo16OO22023.services.IEventoService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
	@GetMapping("/listadoreportes")
	public ModelAndView listadoEventos() {
		ModelAndView mV= new ModelAndView();
		
		mV.setViewName(ViewRouteHelper.REPORTES_LISTADO);
		mV.addObject("listaEventos",eventoService.getAll());
		
		return mV;
	}

}
