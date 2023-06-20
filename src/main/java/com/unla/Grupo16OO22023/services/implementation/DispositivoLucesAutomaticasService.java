package com.unla.Grupo16OO22023.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.converter.DispositivoLucesAutomaticasConverter;
import com.unla.Grupo16OO22023.entities.DispositivoLucesAutomaticas;
import com.unla.Grupo16OO22023.entities.Evento;
import com.unla.Grupo16OO22023.entities.MedicionLucesAutomaticas;
import com.unla.Grupo16OO22023.models.DispositivoLucesAutomaticasModel;
import com.unla.Grupo16OO22023.repositories.IDispositivoLucesAutomaticasRepository;
import com.unla.Grupo16OO22023.repositories.IEventoRepository;
import com.unla.Grupo16OO22023.services.IDispositivoLucesAutomaticasService;

@Service("dispositivoLucesAutomaticasService")
public class DispositivoLucesAutomaticasService implements IDispositivoLucesAutomaticasService{
	@Autowired
	@Qualifier("dispositivoLucesAutomaticasRepository")
	private IDispositivoLucesAutomaticasRepository dispositivoLucesAutomaticasRepository;
	
	@Autowired
	@Qualifier("dispositivoLucesAutomaticasConverter")
	private DispositivoLucesAutomaticasConverter dispositivoLucesAutomaticasConverter;
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;

	@Override
	public List<DispositivoLucesAutomaticas> getAll() {
		return dispositivoLucesAutomaticasRepository.findAll();
	}
	
	@Override
	public DispositivoLucesAutomaticasModel insertOrUpdate(DispositivoLucesAutomaticasModel dispositivoLucesAutomaticasModel) {
		DispositivoLucesAutomaticas dispositivoLucesAutomaticas = dispositivoLucesAutomaticasConverter.modelToEntity(dispositivoLucesAutomaticasModel);
		if (Objects.nonNull(dispositivoLucesAutomaticas.getIdDispositivo())) {
			dispositivoLucesAutomaticas = dispositivoLucesAutomaticasRepository.saveAndFlush(dispositivoLucesAutomaticas);
		}else {
			dispositivoLucesAutomaticas = dispositivoLucesAutomaticasRepository.save(dispositivoLucesAutomaticasConverter.modelToEntity(dispositivoLucesAutomaticasModel));
		}
		return dispositivoLucesAutomaticasConverter.entityToModel(dispositivoLucesAutomaticas);
	}
	

	@Override
	public boolean baja(long id) {
		boolean aux = true;
		
		DispositivoLucesAutomaticas dispositivoLucesAutomaticas = dispositivoLucesAutomaticasRepository.findByidDispositivo(id);
     
		if(dispositivoLucesAutomaticas.isBaja() == false) {
			dispositivoLucesAutomaticas.setBaja(true);
			dispositivoLucesAutomaticas.setActivo(false);
			dispositivoLucesAutomaticasRepository.save(dispositivoLucesAutomaticas);
        }else{
        	aux =false;
        }

		return aux;
	}

	@Override
	public DispositivoLucesAutomaticasModel traerPorId(long id) {
				return dispositivoLucesAutomaticasConverter.entityToModel(dispositivoLucesAutomaticasRepository.findByidDispositivo(id));
	}
	
	@Override
	public Evento crearEvento(MedicionLucesAutomaticas medicionLucesAutomaticas) {

		Evento evento = null;
		String descripcion = "";
		DispositivoLucesAutomaticas dispositivo = medicionLucesAutomaticas.getDispositivoLucesAutomaticas();
		LocalDateTime fechaHora = medicionLucesAutomaticas.getFechaHora();
		
		//Si no hay personas o hay luz se pagan las luces.
		if( (medicionLucesAutomaticas.isHayPersonas() == false) || (medicionLucesAutomaticas.isHayLuz() == true)) {
			descripcion= " Se apagaron las luces";
		}
		
		if((medicionLucesAutomaticas.isHayPersonas() == true && medicionLucesAutomaticas.isHayLuz() == false )) {
			descripcion= " Se prendieron las luces";
		}
		
		evento = new Evento(descripcion, dispositivo, fechaHora);
        evento = eventoRepository.save(evento);
	   
        return evento;
	}

}
