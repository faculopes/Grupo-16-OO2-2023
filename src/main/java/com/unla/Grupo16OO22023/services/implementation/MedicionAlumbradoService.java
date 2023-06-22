package com.unla.Grupo16OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.entities.MedicionAlumbrado;
import com.unla.Grupo16OO22023.repositories.IMedicionAlumbradoRepository;
import com.unla.Grupo16OO22023.services.IMedicionAlumbradoService;

@Service("medicionAlumbradoService")
public class MedicionAlumbradoService implements IMedicionAlumbradoService {

	@Autowired
	@Qualifier("medicionAlumbradoRepository")
	private IMedicionAlumbradoRepository medicionAlumbradoRepository;

	@Override
	public List<MedicionAlumbrado> getAll() {
		
		return medicionAlumbradoRepository.findAll();
	}
	
}
