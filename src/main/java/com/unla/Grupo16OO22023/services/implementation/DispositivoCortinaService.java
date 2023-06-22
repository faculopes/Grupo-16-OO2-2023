package com.unla.Grupo16OO22023.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.converter.DispositivoCortinaConverter;
import com.unla.Grupo16OO22023.entities.DispositivoCortina;
import com.unla.Grupo16OO22023.entities.Evento;
import com.unla.Grupo16OO22023.entities.MedicionCortina;
import com.unla.Grupo16OO22023.models.DispositivoCortinaModel;
import com.unla.Grupo16OO22023.repositories.IDispositivoCortinaRepository;
import com.unla.Grupo16OO22023.repositories.IEventoRepository;
import com.unla.Grupo16OO22023.services.IDispositivoCortinaService;

@Service("dispositivoCortinaService")
public class DispositivoCortinaService implements IDispositivoCortinaService{
	@Autowired
	@Qualifier("dispositivoCortinaRepository")
	private IDispositivoCortinaRepository dispositivoCortinaRepository;
	
	@Autowired
	@Qualifier("dispositivoCortinaConverter")
	private DispositivoCortinaConverter dispositivoCortinaConverter;
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;

	@Override
	public List<DispositivoCortina> getAll() {
		return dispositivoCortinaRepository.findAll();
	}
	
	@Override
	public DispositivoCortinaModel insertOrUpdate(DispositivoCortinaModel dispositivoCortinaModel) {
		DispositivoCortina dispositivoCortina = dispositivoCortinaConverter.modelToEntity(dispositivoCortinaModel);
		if (Objects.nonNull(dispositivoCortina.getIdDispositivo())) {
			dispositivoCortina = dispositivoCortinaRepository.saveAndFlush(dispositivoCortina);
		}else {
			dispositivoCortina = dispositivoCortinaRepository.save(dispositivoCortinaConverter.modelToEntity(dispositivoCortinaModel));
		}
		return dispositivoCortinaConverter.entityToModel(dispositivoCortina);
	}
	

	@Override
	public boolean baja(long id) {
		boolean aux = true;
		
		DispositivoCortina dispositivoCortina = dispositivoCortinaRepository.findByidDispositivo(id);
     
		if(dispositivoCortina.isBaja() == false) {
			dispositivoCortina.setBaja(true);
			dispositivoCortina.setActivo(false);
			dispositivoCortinaRepository.save(dispositivoCortina);
        }else{
        	aux =false;
        }

		return aux;
	}

	@Override
	public DispositivoCortinaModel traerPorId(long id) {
				return dispositivoCortinaConverter.entityToModel(dispositivoCortinaRepository.findByidDispositivo(id));
	}
	
	@Override
	public Evento crearEvento(MedicionCortina medicionCortina) {

		Evento evento = null;
		String descripcion = "";
		DispositivoCortina dispositivo = medicionCortina.getDispositivoCortina();
		LocalDateTime fechaHora = medicionCortina.getFechaHora();
		
		
		if(medicionCortina.getHora().isAfter(medicionCortina.getDispositivoCortina().getAperturaDesde())) {
			
			descripcion= "Se abre la cortina.";
		}
		
		if(medicionCortina.getHora().isAfter(medicionCortina.getDispositivoCortina().getAperturaHasta())) {
			
			descripcion= "Se cierra la cortina.";
		}
		
		
		evento = new Evento(descripcion, dispositivo, fechaHora);
        evento = eventoRepository.save(evento);
	   
        return evento;
	}

}