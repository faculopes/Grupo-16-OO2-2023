package com.unla.Grupo16OO22023.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.unla.Grupo16OO22023.entities.MedicionCortina;
import com.unla.Grupo16OO22023.repositories.IMedicionCortinaRepository;
import com.unla.Grupo16OO22023.services.implementation.DispositivoCortinaService;

@Component
public class MedicionCortinaSchedule {
	
	private final IMedicionCortinaRepository medicionCortinaRepository;
	private final DispositivoCortinaService dispositivoCortinaService;

	public MedicionCortinaSchedule(IMedicionCortinaRepository medicionCortinaRepository, DispositivoCortinaService dispositivoCortinaService) {
		this.medicionCortinaRepository = medicionCortinaRepository;
		this.dispositivoCortinaService = dispositivoCortinaService;
	}

	@Scheduled(fixedDelay = 5000) // Corre cada 15 segundos
	public void processNewMediciones() {
		MedicionCortina ultimaMedicion = medicionCortinaRepository.findTopByOrderByIdMedicionCortinaDesc();
		if(ultimaMedicion != null) {
			if((ultimaMedicion.isProcesado() == false)) {
				if (ultimaMedicion.getDispositivoCortina().isBaja() == false) {
				if (ultimaMedicion.getHora().isAfter(ultimaMedicion.getDispositivoCortina().getAperturaDesde()) || (ultimaMedicion.getHora().isAfter(ultimaMedicion.getDispositivoCortina().getAperturaHasta()))) {
					dispositivoCortinaService.crearEvento(ultimaMedicion);
					ultimaMedicion.setProcesado(true);
					medicionCortinaRepository.save(ultimaMedicion);
				}}}}
	}

}