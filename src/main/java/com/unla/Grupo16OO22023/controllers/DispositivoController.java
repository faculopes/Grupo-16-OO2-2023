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
import com.unla.Grupo16OO22023.models.DispositivoAlumbradoModel;
import com.unla.Grupo16OO22023.models.ZonaModel;
import com.unla.Grupo16OO22023.services.IDispositivoAlumbradoService;
import com.unla.Grupo16OO22023.services.IZonaService;

@Controller
@PreAuthorize("hasRole('ROLE_1')")
@RequestMapping("/dispositivos")
public class DispositivoController {
	

	@GetMapping("/")
	public String crear() {
		return ViewRouteHelper.DISPOSITIVOS;
	}

	
	// MENU DE DISPOSITIVOS DE ALUMBRADO
		@Autowired
		@Qualifier("dispositivoAlumbradoService")
		private IDispositivoAlumbradoService dispositivoAlumbradoService;
		
		@Autowired
		@Qualifier("zonaService")
		private IZonaService zonaService;
		
		//Listado de dispositivos de Alumbrado
		@GetMapping("/alumbrado")
		public ModelAndView listadoAlumbrado() {
			ModelAndView mV= new ModelAndView();
			
			mV.setViewName(ViewRouteHelper.DISP_LISTADO_ALUMBRADO);
			mV.addObject("listaDispositivosAlumbrado", dispositivoAlumbradoService.getAll());
			
			return mV;
		}

		// Formulario para dar de alta un dispositivo de Alumbrado
		@GetMapping("/formularioDispositivoAlumbrado")
		public String formularioDispositivoAlumbrado(Model model) {
			List<Zona> zonas = zonaService.getAll();
			List<Zona> zonasPredeterminadas = zonas.subList(4, 10);
			
			model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
			model.addAttribute("dispositivoAlumbrado", new DispositivoAlumbradoModel());
			return ViewRouteHelper.DISP_FORMULARIO_ALUMBRADO;
		}
		
		// Se confirma el alta del dispositivo de Alumbrado
		@PostMapping("/nuevoDispositivoAlumbrado")
		public ModelAndView nuevoDispositivoAlumbrado(@Valid @ModelAttribute("dispositivoAlumbrado")DispositivoAlumbradoModel dispositivoAlumbrado,
				BindingResult b,Model model) {
			ModelAndView mV = new ModelAndView();

			if(b.hasErrors()) {
				List<Zona> zonas = zonaService.getAll();
				List<Zona> zonasPredeterminadas = zonas.subList(4, 10);
				
				model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
				mV.setViewName(ViewRouteHelper.DISP_FORMULARIO_ALUMBRADO);

			}else {
			     long idZonaSeleccionada = dispositivoAlumbrado.getZona().getIdZona();
			     ZonaModel zonaSeleccionada = zonaService.getById(idZonaSeleccionada);
			     
			     dispositivoAlumbrado.setZona(zonaSeleccionada);
				 dispositivoAlumbrado.setActivo(true);
				 dispositivoAlumbrado.setBaja(false);
		
				
				dispositivoAlumbradoService.insertOrUpdate(dispositivoAlumbrado);		
				mV.setViewName(ViewRouteHelper.DISP_NUEVO_ALUMBRADO);
				mV.addObject("dispositivoAlumbrado", dispositivoAlumbrado);

			}

			return mV;
		}
		
		// Formulario para editar un dispositivo de Alumbrado
		@GetMapping("/formularioEditarDispositivoAlumbrado/{id}")
		public String editarDispositivoAlumbrado(@PathVariable("id")int id, Model model) {
			List<Zona> zonas = zonaService.getAll();
			List<Zona> zonasPredeterminadas = zonas.subList(4, 10);
			model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
			
			DispositivoAlumbradoModel dispositivoAlumbrado = dispositivoAlumbradoService.traerPorId(id);
			model.addAttribute("dispositivoAlumbrado", dispositivoAlumbrado);		

			return ViewRouteHelper.DISP_EDITAR_ALUMBRADO;
		}
		
		// Se confirma la modificacion del dispositivo de Alumbrado
		@PostMapping("/editadoDispositivoAlumbrado")
		public ModelAndView editadoDispositivoAlumbrado(@Valid @ModelAttribute("dispositivoAlumbrado")DispositivoAlumbradoModel dispositivoAlumbrado,
				BindingResult b,Model model) {
			ModelAndView mV = new ModelAndView();
			
			if(b.hasErrors()) {
				List<Zona> zonas = zonaService.getAll();
				List<Zona> zonasPredeterminadas = zonas.subList(4, 10);
				model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
				mV.setViewName(ViewRouteHelper.DISP_EDITAR_ALUMBRADO);
			}else {
				long idZonaSeleccionada = dispositivoAlumbrado.getZona().getIdZona();
				ZonaModel zonaSeleccionada = zonaService.getById(idZonaSeleccionada);
				dispositivoAlumbrado.setZona(zonaSeleccionada);

				if(dispositivoAlumbrado.isActivo() == true) {
					dispositivoAlumbrado.setBaja(false);
				}else {
					dispositivoAlumbrado.setBaja(true);
				}

				Long idDispositivo = dispositivoAlumbrado.getIdDispositivo();
				dispositivoAlumbrado.setIdDispositivo(idDispositivo);

				dispositivoAlumbradoService.insertOrUpdate(dispositivoAlumbrado);


				mV.setViewName(ViewRouteHelper.DISP_EDITADO_ALUMBRADO);
				mV.addObject("dispositivoAlumbrado", dispositivoAlumbrado);
			}

			return mV;
		}
		
		@GetMapping("/bajaDispositivoAlumbrado/{id}")
		public ModelAndView bajaDispositivoLucesAutomaticas (@PathVariable("id")long id, Model model) {
			dispositivoAlumbradoService.remove(id);
			return listadoAlumbrado();
		}
}
