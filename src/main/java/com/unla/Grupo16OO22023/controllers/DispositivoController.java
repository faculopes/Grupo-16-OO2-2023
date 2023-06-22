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
import com.unla.Grupo16OO22023.models.DispositivoLucesAutomaticasModel;
import com.unla.Grupo16OO22023.models.DispositivoTemperaturaModel;
import com.unla.Grupo16OO22023.models.ZonaModel;
import com.unla.Grupo16OO22023.services.IDispositivoAlumbradoService;
import com.unla.Grupo16OO22023.services.IDispositivoLucesAutomaticasService;
import com.unla.Grupo16OO22023.services.IDispositivoTemperaturaService;
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
	// Formulario para dar de alta un dispositivo de LucesAutomaticas
	

	@GetMapping("/")
	public String crear() {
		return ViewRouteHelper.DISPOSITIVOS;
	}

	
	// MENU DE DISPOSITIVOS DE ALUMBRADO
		@Autowired
		@Qualifier("dispositivoAlumbradoService")
		private IDispositivoAlumbradoService dispositivoAlumbradoService;
		
		
		
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

}
