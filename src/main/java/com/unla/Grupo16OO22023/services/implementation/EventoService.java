package com.unla.Grupo16OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.entities.Evento;
import com.unla.Grupo16OO22023.repositories.IEventoRepository;
import com.unla.Grupo16OO22023.services.IEventoService;

@Service("eventoService")
public class EventoService implements IEventoService{

	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	
	@Override
	public List<Evento> getAll(){
		
		return eventoRepository.findAll();	}
	
}
