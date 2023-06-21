package com.unla.Grupo16OO22023.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.unla.Grupo16OO22023.entities.MedicionTemperatura;
import com.unla.Grupo16OO22023.repositories.IMedicionesTemperaturaRepository;
import com.unla.Grupo16OO22023.services.implementation.DispositivoTemperaturaService;

@Component
public class MedicionTemperaturaSchedule {
	
	private final IMedicionesTemperaturaRepository medicionTemperaturaRepository;
	private final DispositivoTemperaturaService dispositivoTemperaturaService;

	public MedicionTemperaturaSchedule(IMedicionesTemperaturaRepository medicionTemperaturaRepository, DispositivoTemperaturaService dispositivoTemperaturaService) {
		this.medicionTemperaturaRepository = medicionTemperaturaRepository;
		this.dispositivoTemperaturaService = dispositivoTemperaturaService;
	}

	@Scheduled(fixedDelay = 5000) // Corre cada 15 segundos
	public void processNewMediciones() {

		MedicionTemperatura ultimaMedicion = medicionTemperaturaRepository.findTopByOrderByIdMedicionTemperaturaDesc();
		if(ultimaMedicion != null) {
			if((ultimaMedicion.isProcesado() == false)) {
				if (ultimaMedicion.getDispositivoTemperatura().isBaja() == false) {
				if (((ultimaMedicion.getTemperatura() >= ultimaMedicion.getDispositivoTemperatura().getCalorExcesivo())) || (ultimaMedicion.getTemperatura() <= ultimaMedicion.getDispositivoTemperatura().getCalorExcesivo())) {
					dispositivoTemperaturaService.crearEvento(ultimaMedicion);
					ultimaMedicion.setProcesado(true);
					medicionTemperaturaRepository.save(ultimaMedicion);
				}}}}
	}

}