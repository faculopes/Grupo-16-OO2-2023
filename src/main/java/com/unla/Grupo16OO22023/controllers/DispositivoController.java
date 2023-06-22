package com.unla.Grupo16OO22023.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo16OO22023.entities.Zona;
import com.unla.Grupo16OO22023.entities.Zona;
import com.unla.Grupo16OO22023.helpers.ViewRouteHelper;
import com.unla.Grupo16OO22023.models.DispositivoTemperaturaModel;
import com.unla.Grupo16OO22023.models.ZonaModel;
import com.unla.Grupo16OO22023.services.IDispositivoTemperaturaService;
import com.unla.Grupo16OO22023.services.IZonaService;
import com.unla.Grupo16OO22023.models.DispositivoCortinaModel;
import com.unla.Grupo16OO22023.models.DispositivoLucesAutomaticasModel;
import com.unla.Grupo16OO22023.models.ZonaModel;
import com.unla.Grupo16OO22023.services.IDispositivoCortinaService;
import com.unla.Grupo16OO22023.services.IDispositivoLucesAutomaticasService;
import com.unla.Grupo16OO22023.services.IZonaService;

@Controller
@PreAuthorize("hasRole('ROLE_1')")
@RequestMapping("/dispositivos")
public class DispositivoController {
	@Autowired
	@Qualifier("zonaService")
	private IZonaService zonaService;
	@Autowired
	@Qualifier("dispositivoTemperaturaService")
	private IDispositivoTemperaturaService dispositivoTemperaturaService; 
	@Autowired
	@Qualifier("dispositivoCortinaService")
	private IDispositivoCortinaService dispositivoCortinaService; 
	// Formulario para dar de alta un dispositivo de LucesAutomaticas
	

	

	


    // MENU PRINCIPAL DE DISPOSITIVOS
	@GetMapping("/")
	public String crear() {
		return ViewRouteHelper.DISPOSITIVOS;
	}
	
	
	// MENU DE DISPOSITIVOS DE LUCES AUTOMATICAS
	@Autowired
	@Qualifier("dispositivoLucesAutomaticasService")
	private IDispositivoLucesAutomaticasService dispositivoLucesAutomaticasService;
	
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
		@GetMapping("/temperatura")
		public ModelAndView listadoTemperatura() {
			ModelAndView mV= new ModelAndView();
			
			mV.setViewName(ViewRouteHelper.DISP_LISTADO_TEMPERATURA);
			mV.addObject("listaDispositivosTemperatura", dispositivoTemperaturaService.getAll());
			
			return mV;
		}
		@GetMapping("/formularioDispositivoTemperatura")
		public String formularioDispositivoTemperatura(Model model) {
			List<Zona> zonas = zonaService.getAll();
			List<Zona> zonasPredeterminadas = zonas.subList(0, 4);
			
			model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
			model.addAttribute("dispositivoTemperatura", new DispositivoTemperaturaModel());
			return ViewRouteHelper.DISP_FORMULARIO_TEMPERATURA;
		}
		// Se confirma el alta del dispositivo de LucesAutomatica 
		@PostMapping("/nuevoDispositivoTemperatura")
		public ModelAndView nuevoDispositivoTemperatura(@Valid @ModelAttribute("dispositivoTemperatura")DispositivoTemperaturaModel dispositivoTemperatura,
				BindingResult b) {
			ModelAndView mV = new ModelAndView();
			if(b.hasErrors()) {
				mV.setViewName(ViewRouteHelper.DISP_FORMULARIO_TEMPERATURA);
			}else {
			     Long idZonaSeleccionada = dispositivoTemperatura.getZona().getIdZona();
			     ZonaModel zonaSeleccionada = zonaService.getById(idZonaSeleccionada);	     
			     dispositivoTemperatura.setZona(zonaSeleccionada);
				 dispositivoTemperatura.setActivo(true);
				 dispositivoTemperatura.setBaja(false);
				dispositivoTemperaturaService.insertOrUpdate(dispositivoTemperatura);		
				mV.setViewName(ViewRouteHelper.DISP_NUEVO_TEMPERATURA);
				mV.addObject("dispositivoTemperatura", dispositivoTemperatura);

			}
			return mV;
		}
		// Formulario para editar un dispositivo de LucesAutomaticas
		@GetMapping("/formularioEditarDispositivoTemperatura/{id}")
		public String editarDispositivoTemperatura(@PathVariable("id")int id, Model model) {
			List<Zona> zonas = zonaService.getAll();
			List<Zona> zonasPredeterminadas = zonas.subList(0, 4);
			model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);			
			DispositivoTemperaturaModel dispositivoTemperatura = dispositivoTemperaturaService.traerPorId(id);
			model.addAttribute("dispositivoTemperatura", dispositivoTemperatura);		
			return ViewRouteHelper.DISP_EDITAR_TEMPERATURA;
		}
		
		// Se confirma la modificacion del dispositivo de LucesAutomaticas
		@PostMapping("/editadoDispositivoTemperatura")
		public ModelAndView editadoDispositivoTemperatura(@Valid @ModelAttribute("dispositivoTemperatura")DispositivoTemperaturaModel dispositivoTemperatura,
				BindingResult b) {
			ModelAndView mV = new ModelAndView();
			
			if(b.hasErrors()) {
				mV.setViewName(ViewRouteHelper.DISP_EDITAR_TEMPERATURA);
			}else {
				Long idZonaSeleccionada = dispositivoTemperatura.getZona().getIdZona();
				ZonaModel zonaSeleccionada = zonaService.getById(idZonaSeleccionada);
				dispositivoTemperatura.setZona(zonaSeleccionada);
				if(dispositivoTemperatura.isActivo() == true) {
					dispositivoTemperatura.setBaja(false);
				}else {
					dispositivoTemperatura.setBaja(true);
				}
				Long idDispositivo = dispositivoTemperatura.getIdDispositivo();
				dispositivoTemperatura.setIdDispositivo(idDispositivo);
				dispositivoTemperaturaService.insertOrUpdate(dispositivoTemperatura);
				mV.setViewName(ViewRouteHelper.DISP_EDITADO_TEMPERATURA);
				mV.addObject("dispositivoTemperatura", dispositivoTemperatura);
			}
			return mV;
		}
		@GetMapping("/bajaDispositivoTemperatura/{id}")
		public ModelAndView bajaDispositivoTemperatura (@PathVariable("id")long id, Model model) {
			dispositivoTemperaturaService.baja(id);
			return listadoTemperatura();
		}
		
		
	//PARTE BELU - CORTINA
		@GetMapping("/cortina")
		public ModelAndView listadoCortina() {
			ModelAndView mV= new ModelAndView();
			
			mV.setViewName(ViewRouteHelper.DISP_LISTADO_CORTINA);
			mV.addObject("listaDispositivosCortina", dispositivoCortinaService.getAll());
			
			return mV;
		}
		@GetMapping("/formularioCortina")
		public String formularioCortina(Model model) {
			List<Zona> zonas = zonaService.getAll();
			List<Zona> zonasPredeterminadas = zonas.subList(0, 4);
			
			model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
			model.addAttribute("dispositivoCortina", new DispositivoCortinaModel());
			return ViewRouteHelper.DISP_FORMULARIO_CORTINA;
		}
		// Se confirma el alta del dispositivo 
		@PostMapping("/nuevoDispositivoCortina")
		public ModelAndView nuevoDispositivoCortina(@Valid @ModelAttribute("dispositivoCortina")DispositivoCortinaModel dispositivoCortina,
				BindingResult b, Model model) {
			ModelAndView mV = new ModelAndView();
			if(b.hasErrors()) {
				List<Zona> zonas = zonaService.getAll();
				List<Zona> zonasPredeterminadas = zonas.subList(0, 4);
				model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
				mV.setViewName(ViewRouteHelper.DISP_FORMULARIO_CORTINA);
			}else {
			     long idZonaSeleccionada = dispositivoCortina.getZona().getIdZona();
			     ZonaModel zonaSeleccionada = zonaService.getById(idZonaSeleccionada);	     
			     dispositivoCortina.setZona(zonaSeleccionada);
				 dispositivoCortina.setActivo(true);
				 dispositivoCortina.setBaja(false);
				dispositivoCortinaService.insertOrUpdate(dispositivoCortina);		
				mV.setViewName(ViewRouteHelper.DISP_NUEVO_CORTINA);
				mV.addObject("dispositivoCortina", dispositivoCortina);

			}
			return mV;
		}
		// Formulario para editar un dispositivo
		@GetMapping("/formularioEditarCortina/{id}")
		public String editarDispositivoCortina(@PathVariable("id")int id, Model model) {
			List<Zona> zonas = zonaService.getAll();
			List<Zona> zonasPredeterminadas = zonas.subList(0, 4);
			model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);			
			DispositivoCortinaModel dispositivoCortina = dispositivoCortinaService.traerPorId(id);
			model.addAttribute("dispositivoCortina", dispositivoCortina);		
			return ViewRouteHelper.DISP_EDITAR_CORTINA;
		}
		
		// Se confirma la modificacion del dispositivo
		@PostMapping("/editadoDispositivoCortina")
		public ModelAndView editadoDispositivoCortina(@Valid @ModelAttribute("dispositivoCortina")DispositivoCortinaModel dispositivoCortina,
				BindingResult b, Model model) {
			ModelAndView mV = new ModelAndView();
			
			if(b.hasErrors()) {
				List<Zona> zonas = zonaService.getAll();
				List<Zona> zonasPredeterminadas = zonas.subList(0, 4);
				model.addAttribute("zonasPredeterminadas", zonasPredeterminadas);
				mV.setViewName(ViewRouteHelper.DISP_EDITAR_CORTINA);
			}else {
				long idZonaSeleccionada = dispositivoCortina.getZona().getIdZona();
				ZonaModel zonaSeleccionada = zonaService.getById(idZonaSeleccionada);
				dispositivoCortina.setZona(zonaSeleccionada);
				if(dispositivoCortina.isActivo() == true) {
					dispositivoCortina.setBaja(false);
				}else {
					dispositivoCortina.setBaja(true);
				}
				long idDispositivo = dispositivoCortina.getIdDispositivo();
				dispositivoCortina.setIdDispositivo(idDispositivo);
				dispositivoCortinaService.insertOrUpdate(dispositivoCortina);
				mV.setViewName(ViewRouteHelper.DISP_EDITADO_CORTINA);
				mV.addObject("dispositivoCortina", dispositivoCortina);
			}
			return mV;
		}
		@GetMapping("/bajaDispositivoCortina/{id}")
		public ModelAndView bajaDispositivoCortina (@PathVariable("id")long id, Model model) {
			dispositivoCortinaService.baja(id);
			return listadoCortina();
		}
}