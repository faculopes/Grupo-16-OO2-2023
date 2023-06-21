package com.unla.Grupo16OO22023.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.converter.DispositivoTemperaturaConverter;
import com.unla.Grupo16OO22023.entities.DispositivoTemperatura;
import com.unla.Grupo16OO22023.entities.Evento;
import com.unla.Grupo16OO22023.entities.MedicionTemperatura;
import com.unla.Grupo16OO22023.models.DispositivoTemperaturaModel;
import com.unla.Grupo16OO22023.repositories.IDispositivoTemperaturaRepository;
import com.unla.Grupo16OO22023.repositories.IEventoRepository;
import com.unla.Grupo16OO22023.services.IDispositivoTemperaturaService;

@Service("dispositivoTemperaturaService")
public class DispositivoTemperaturaService implements IDispositivoTemperaturaService{
	@Autowired
	@Qualifier("dispositivoTemperaturaRepository")
	private IDispositivoTemperaturaRepository dispositivoTemperaturaRepository;
	
	@Autowired
	@Qualifier("dispositivoTemperaturaConverter")
	private DispositivoTemperaturaConverter dispositivoTemperaturaConverter;
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;

	@Override
	public List<DispositivoTemperatura> getAll() {
		return dispositivoTemperaturaRepository.findAll();
	}
	
	@Override
	public DispositivoTemperaturaModel insertOrUpdate(DispositivoTemperaturaModel dispositivoTemperaturaModel) {
		DispositivoTemperatura dispositivoTemperatura = dispositivoTemperaturaConverter.modelToEntity(dispositivoTemperaturaModel);
		if (Objects.nonNull(dispositivoTemperatura.getIdDispositivo())) {
			dispositivoTemperatura = dispositivoTemperaturaRepository.saveAndFlush(dispositivoTemperatura);
		}else {
			dispositivoTemperatura = dispositivoTemperaturaRepository.save(dispositivoTemperaturaConverter.modelToEntity(dispositivoTemperaturaModel));
		}
		return dispositivoTemperaturaConverter.entityToModel(dispositivoTemperatura);
	}
	

	@Override
	public boolean baja(long id) {
		boolean aux = true;
		
		DispositivoTemperatura dispositivoTemperatura = dispositivoTemperaturaRepository.findByidDispositivo(id);
     
		if(dispositivoTemperatura.isBaja() == false) {
			dispositivoTemperatura.setBaja(true);
			dispositivoTemperatura.setActivo(false);
			dispositivoTemperaturaRepository.save(dispositivoTemperatura);
        }else{
        	aux =false;
        }

		return aux;
	}

	@Override
	public DispositivoTemperaturaModel traerPorId(long id) {
				return dispositivoTemperaturaConverter.entityToModel(dispositivoTemperaturaRepository.findByidDispositivo(id));
	}
	
	@Override
	public Evento crearEvento(MedicionTemperatura medicionTemperatura) {

		Evento evento = null;
		String descripcion = "";
		DispositivoTemperatura dispositivo = medicionTemperatura.getDispositivoTemperatura();
		LocalDateTime fechaHora = medicionTemperatura.getFechaHora();
		
		//Si no hay personas o hay luz se pagan las luces.
		if( (medicionTemperatura.getTemperatura() >= medicionTemperatura.getDispositivoTemperatura().getCalorExcesivo())) {
			dispositivo.setAireAcondicionado(true);
			descripcion= " Se prende el aire";
		} else {
			dispositivo.setAireAcondicionado(false);
			descripcion= " Se apaga el aire";
		}
		
		evento = new Evento(descripcion, dispositivo, fechaHora);
        evento = eventoRepository.save(evento);
	   
        return evento;
	}

}