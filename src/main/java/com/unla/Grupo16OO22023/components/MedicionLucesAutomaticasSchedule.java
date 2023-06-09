package com.unla.Grupo16OO22023.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.Grupo16OO22023.entities.MedicionLucesAutomaticas;
import com.unla.Grupo16OO22023.repositories.IMedicionLucesAutomaticasRepository;
import com.unla.Grupo16OO22023.services.implementation.DispositivoLucesAutomaticasService;

@Component
public class MedicionLucesAutomaticasSchedule {
	
	private final IMedicionLucesAutomaticasRepository medicionLucesAutomaticasRepository;
	private final DispositivoLucesAutomaticasService dispositivoLucesAutomaticasService;

	public MedicionLucesAutomaticasSchedule(IMedicionLucesAutomaticasRepository medicionLucesAutomaticasRepository, DispositivoLucesAutomaticasService dispositivoLucesAutomaticasService) {
		this.medicionLucesAutomaticasRepository = medicionLucesAutomaticasRepository;
		this.dispositivoLucesAutomaticasService = dispositivoLucesAutomaticasService;
	}

	@Scheduled(fixedDelay = 5000) // Corre cada 15 segundos
	public void processNewMediciones() {

		MedicionLucesAutomaticas ultimaMedicion = medicionLucesAutomaticasRepository.findTopByOrderByIdMedicionLucesAutomaticasDesc();
		if(ultimaMedicion != null) {
			if((ultimaMedicion.isProcesado() == false)) {
				if (ultimaMedicion.getDispositivoLucesAutomaticas().isBaja() == false) {
				if (((ultimaMedicion.isHayPersonas() == false) || (ultimaMedicion.isHayLuzNatural() == true)) && ((ultimaMedicion.isLucesPrendidas() == true ))// Si hay que apagar las luces, y la luces no estan apagadas
			     || ((ultimaMedicion.isHayPersonas() == true && ultimaMedicion.isHayLuzNatural() == false )) && (ultimaMedicion.isLucesPrendidas() == false)) { // Si hay que prender las luces, y la luces no estan prendidas
					dispositivoLucesAutomaticasService.crearEvento(ultimaMedicion);
					ultimaMedicion.setProcesado(true);
					medicionLucesAutomaticasRepository.save(ultimaMedicion);
				}}}}
	}

}
