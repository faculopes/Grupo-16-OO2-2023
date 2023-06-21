package com.unla.Grupo16OO22023.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo16OO22023.entities.MedicionLucesAutomaticas;
import com.unla.Grupo16OO22023.repositories.IMedicionLucesAutomaticasRepository;
import com.unla.Grupo16OO22023.services.IMedicionLucesAutomaticasService;

@Service("medicionLucesAutomaticasService")
public class MedicionLucesAutomaticasService implements IMedicionLucesAutomaticasService{
	
	@Autowired
	@Qualifier("medicionLucesAutomaticasRepository")
	private IMedicionLucesAutomaticasRepository medicionLucesAutomaticasRepository;
	
	@Override
	public List<MedicionLucesAutomaticas> getAll() {
		return medicionLucesAutomaticasRepository.findAll();
	}

}
