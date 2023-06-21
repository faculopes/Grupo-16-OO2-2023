package com.unla.Grupo16OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.repositories.IZonaRepository;
import com.unla.Grupo16OO22023.services.IZonaService;
import com.unla.Grupo16OO22023.converter.ZonaConverter;
import com.unla.Grupo16OO22023.entities.Zona;
import com.unla.Grupo16OO22023.models.ZonaModel;

@Service("zonaService")
public class ZonaService implements IZonaService{
	
	@Autowired
	@Qualifier("zonaRepository")
	private IZonaRepository zonaRepository;
	
	@Autowired
	@Qualifier("zonaConverter")
	private ZonaConverter zonaConverter;

	@Override
	public List<Zona> getAll() {
		return zonaRepository.findAll();
	}

	@Override
	public ZonaModel getById(Long id) {
		Zona zona = zonaRepository.findByidZona(id);
		return zonaConverter.entityToModel(zona);
	}
<<<<<<< HEAD
	

}
=======

}
>>>>>>> origin/Dev
