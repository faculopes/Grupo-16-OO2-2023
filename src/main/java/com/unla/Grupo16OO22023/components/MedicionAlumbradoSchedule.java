package com.unla.Grupo16OO22023.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.Grupo16OO22023.entities.MedicionAlumbrado;
import com.unla.Grupo16OO22023.repositories.IMedicionAlumbradoRepository;
import com.unla.Grupo16OO22023.services.implementation.DispositivoAlumbradoService;

@Component
public class MedicionAlumbradoSchedule {

	private final IMedicionAlumbradoRepository medicionAlumbradoRepository;
	private final DispositivoAlumbradoService dispositivoAlumbradoService;
	
	public MedicionAlumbradoSchedule(IMedicionAlumbradoRepository medicionAlumbradoRepository,DispositivoAlumbradoService dispositivoAlumbradoService ) {
		
		this.medicionAlumbradoRepository=medicionAlumbradoRepository;
		this.dispositivoAlumbradoService=dispositivoAlumbradoService;
	}
	
	@Scheduled(fixedDelay = 5000)
	public void processNewMediciones() {
		
		MedicionAlumbrado ultimaMedicion = medicionAlumbradoRepository.findTopByOrderByIdMedicionAlumbradoDesc();
		
		if(ultimaMedicion != null) {
			if((ultimaMedicion.isProcesado() == false)) {
				if (ultimaMedicion.getDispositivoAlumbrado().isBaja() == false) {
				if (((ultimaMedicion.isHayPersonas() == false) || (ultimaMedicion.isHayLuzNatural() == true)) && ((ultimaMedicion.isLucesPrendidas() == true ))// Si hay que apagar las luces, y la luces no estan apagadas
			     || ((ultimaMedicion.isHayPersonas() == true && ultimaMedicion.isHayLuzNatural() == false )) && (ultimaMedicion.isLucesPrendidas() == false)) { // Si hay que prender las luces, y la luces no estan prendidas
					dispositivoAlumbradoService.crearEvento(ultimaMedicion);
					ultimaMedicion.setProcesado(true);
					medicionAlumbradoRepository.save(ultimaMedicion);
				}}}}
	}
}
