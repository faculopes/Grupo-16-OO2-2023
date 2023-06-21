package com.unla.Grupo16OO22023.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo16OO22023.entities.Zona;
import com.unla.Grupo16OO22023.helpers.ViewRouteHelper;
import com.unla.Grupo16OO22023.models.DispositivoLucesAutomaticasModel;
import com.unla.Grupo16OO22023.models.ZonaModel;
import com.unla.Grupo16OO22023.services.IDispositivoLucesAutomaticasService;
import com.unla.Grupo16OO22023.services.IZonaService;

@Controller
@PreAuthorize("hasRole('ROLE_1')")
@RequestMapping("/dispositivos")
public class DispositivoController {
	

	

	


    // MENU PRINCIPAL DE DISPOSITIVOS
	@GetMapping("/")
	public String crear() {
		return ViewRouteHelper.DISPOSITIVOS;
	}
	
	
	// MENU DE DISPOSITIVOS DE LUCES AUTOMATICAS
	@Autowired
	@Qualifier("dispositivoLucesAutomaticasService")
	private IDispositivoLucesAutomaticasService dispositivoLucesAutomaticasService;
	
	@Autowired
	@Qualifier("zonaService")
	private IZonaService zonaService;
	
	//Listado de dispositivos de LucesAutomaticas
	@GetMapping("/lucesAutomaticas")
	public ModelAndView listadoLucesAutomaticas() {
		ModelAndView mV= new ModelAndView();
		
		mV.setViewName(ViewRouteHelper.DISP_LISTADO_LUCES_AUTOMATICAS);
		mV.addObject("listaDispositivosLucesAutomaticas", dispositivoLucesAutomaticasService.getAll());
		
		return mV;
	}

	// Formulario para dar de alta un dispositivo de LucesAutomaticas
	@GetMapping("/formularioDispositivoLucesAutomaticas")
	public String formularioDispositivoLucesAutomaticas(Model model) {
		List<Zona> zonas = zonaService.getAll();
		List<Zona> zonasPredeterminadas = zonas.subList(0, 4);
		
		model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
		model.addAttribute("dispositivoLucesAutomaticas", new DispositivoLucesAutomaticasModel());
		return ViewRouteHelper.DISP_FORMULARIO_LUCES_AUTOMATICAS;
	}
	
	// Se confirma el alta del dispositivo de LucesAutomaticas
	@PostMapping("/nuevoDispositivoLucesAutomaticas")
	public ModelAndView nuevoDispositivoLucesAutomaticas(@Valid @ModelAttribute("dispositivoLucesAutomaticas")DispositivoLucesAutomaticasModel dispositivoLucesAutomaticas,
			BindingResult b) {
		ModelAndView mV = new ModelAndView();

		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.DISP_FORMULARIO_LUCES_AUTOMATICAS);

		}else {
		     Long idZonaSeleccionada = dispositivoLucesAutomaticas.getZona().getIdZona();
		     ZonaModel zonaSeleccionada = zonaService.getById(idZonaSeleccionada);
		     
		     dispositivoLucesAutomaticas.setZona(zonaSeleccionada);
			 dispositivoLucesAutomaticas.setActivo(true);
			 dispositivoLucesAutomaticas.setBaja(false);
	
			
			dispositivoLucesAutomaticasService.insertOrUpdate(dispositivoLucesAutomaticas);		
			mV.setViewName(ViewRouteHelper.DISP_NUEVO_LUCES_AUTOMATICAS);
			mV.addObject("dispositivoLucesAutomaticas", dispositivoLucesAutomaticas);

		}

		return mV;
	}
	
	// Formulario para editar un dispositivo de LucesAutomaticas
	@GetMapping("/formularioEditarDispositivoLucesAutomaticas/{id}")
	public String editarDispositivoLucesAutomaticas(@PathVariable("id")int id, Model model) {
		List<Zona> zonas = zonaService.getAll();
		List<Zona> zonasPredeterminadas = zonas.subList(0, 4);
		model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
		
		DispositivoLucesAutomaticasModel dispositivoLucesAutomaticas = dispositivoLucesAutomaticasService.traerPorId(id);
		model.addAttribute("dispositivoLucesAutomaticas", dispositivoLucesAutomaticas);		

		return ViewRouteHelper.DISP_EDITAR_LUCES_AUTOMATICAS;
	}
	
	// Se confirma la modificacion del dispositivo de LucesAutomaticas
	@PostMapping("/editadoDispositivoLucesAutomaticas")
	public ModelAndView editadoDispositivoLucesAutomaticas(@Valid @ModelAttribute("dispositivoLucesAutomaticas")DispositivoLucesAutomaticasModel dispositivoLucesAutomaticas,
			BindingResult b) {
		ModelAndView mV = new ModelAndView();
		
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.DISP_EDITAR_LUCES_AUTOMATICAS);
		}else {
			Long idZonaSeleccionada = dispositivoLucesAutomaticas.getZona().getIdZona();
			ZonaModel zonaSeleccionada = zonaService.getById(idZonaSeleccionada);
			dispositivoLucesAutomaticas.setZona(zonaSeleccionada);

			if(dispositivoLucesAutomaticas.isActivo() == true) {
				dispositivoLucesAutomaticas.setBaja(false);
			}else {
				dispositivoLucesAutomaticas.setBaja(true);
			}

			Long idDispositivo = dispositivoLucesAutomaticas.getIdDispositivo();
			dispositivoLucesAutomaticas.setIdDispositivo(idDispositivo);

			dispositivoLucesAutomaticasService.insertOrUpdate(dispositivoLucesAutomaticas);


			mV.setViewName(ViewRouteHelper.DISP_EDITADO_LUCES_AUTOMATICAS);
			mV.addObject("dispositivoLucesAutomaticas", dispositivoLucesAutomaticas);
		}

		return mV;
	}
	
	@GetMapping("/bajaDispositivoLucesAutomaticas/{id}")
	public ModelAndView bajaDispositivoLucesAutomaticas (@PathVariable("id")long id, Model model) {
		dispositivoLucesAutomaticasService.baja(id);
		return listadoLucesAutomaticas();
	}
}
