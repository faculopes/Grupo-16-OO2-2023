package com.unla.Grupo16OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.entities.MedicionCortina;
import com.unla.Grupo16OO22023.repositories.IMedicionCortinaRepository;
import com.unla.Grupo16OO22023.services.IMedicionCortinaService;

@Service("medicionCortinaService")
public class MedicionCortinaService implements IMedicionCortinaService{
	
	@Autowired
	@Qualifier("medicionCortinaRepository")
	private IMedicionCortinaRepository medicionCortinaRepository;
	
	@Override
	public List<MedicionCortina> getAll() {
		return medicionCortinaRepository.findAll();
	}

}
