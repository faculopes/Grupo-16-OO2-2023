package com.unla.Grupo16OO22023.services.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.converter.DispositivoAlumbradoConverter;
import com.unla.Grupo16OO22023.entities.DispositivoAlumbrado;
import com.unla.Grupo16OO22023.entities.Evento;
import com.unla.Grupo16OO22023.entities.MedicionAlumbrado;
import com.unla.Grupo16OO22023.models.DispositivoAlumbradoModel;
import com.unla.Grupo16OO22023.repositories.IDispositivoAlumbradoRepository;
import com.unla.Grupo16OO22023.repositories.IEventoRepository;
import com.unla.Grupo16OO22023.services.IDispositivoAlumbradoService;

@Service("dispositivoAlumbradoService")
public class DispositivoAlumbradoService implements IDispositivoAlumbradoService {

	@Autowired
	@Qualifier("dispositivoAlumbradoRepository")
    private IDispositivoAlumbradoRepository dispositivoAlumbradoRepository;
	
	@Autowired
	@Qualifier("dispositivoAlumbradoConverter")
    private DispositivoAlumbradoConverter dispositivoAlumbradoConverter;
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	
	@Override
	public List<DispositivoAlumbrado> getAll(){
		return dispositivoAlumbradoRepository.findAll();
		
	}
	
	@Override
	public DispositivoAlumbradoModel insertOrUpdate(DispositivoAlumbradoModel dispositivoAlumbradoModelo) {
		
		DispositivoAlumbrado dispositivoAlumbrado= dispositivoAlumbradoConverter.modelToEntity(dispositivoAlumbradoModelo);
		
		if(Objects.nonNull(dispositivoAlumbrado.getIdDispositivo())) {
			dispositivoAlumbrado=dispositivoAlumbradoRepository.saveAndFlush(dispositivoAlumbrado);
		}else {
			dispositivoAlumbrado=dispositivoAlumbradoRepository.save(dispositivoAlumbradoConverter.modelToEntity(dispositivoAlumbradoModelo));
		}
		return dispositivoAlumbradoConverter.entityToModel(dispositivoAlumbrado);
				
	}

	@Override
	public boolean remove(long id) {
		
		boolean aux = true;
		
		DispositivoAlumbrado dispositivoAlumbrado= dispositivoAlumbradoRepository.findByidDispositivo(id);
		
		if(dispositivoAlumbrado.isBaja()==false) {
			dispositivoAlumbrado.setBaja(true);
			dispositivoAlumbrado.setActivo(false);
			dispositivoAlumbradoRepository.save(dispositivoAlumbrado);
		}else {
			aux=false;
			
		}
		
		
		return aux;
	}

	@Override
	public DispositivoAlumbradoModel traerPorId(long id) {
	
		return dispositivoAlumbradoConverter.entityToModel(dispositivoAlumbradoRepository.findByidDispositivo(id));
		
	}

	@Override
	public Evento crearEvento(MedicionAlumbrado medicionAlumbrado) {
		
		Evento evento=null;
		String desc="";
		DispositivoAlumbrado dispositivoAlumbrado=medicionAlumbrado.getDispositivoAlumbrado();
		LocalDateTime fechaHora= medicionAlumbrado.getFechaHora();
		
		if((medicionAlumbrado.isHayPersonas() == false) || (medicionAlumbrado.isHayLuzNatural()==true)) {
			
			desc="Se apagaron las luces";
			
		}
		
		if((medicionAlumbrado.isHayPersonas()==true && medicionAlumbrado.isHayLuzNatural()==false)) {
			
			desc="se prendieron las luces";
		}
		
		evento=new Evento(desc,dispositivoAlumbrado,fechaHora);
		
		evento=eventoRepository.save(evento);
		
		return evento;
	}
	
}
	
	
	
	
