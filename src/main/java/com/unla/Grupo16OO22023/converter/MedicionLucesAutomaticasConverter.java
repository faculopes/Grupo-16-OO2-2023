package com.unla.Grupo16OO22023.converter;

import org.springframework.stereotype.Component;

import com.unla.Grupo16OO22023.entities.MedicionLucesAutomaticas;
import com.unla.Grupo16OO22023.models.MedicionLucesAutomaticasModel;

@Component("medicionLucesAutomaticasConverter")
public class MedicionLucesAutomaticasConverter {
	
	public MedicionLucesAutomaticasModel entityToModel(MedicionLucesAutomaticas medicionLucesAutomaticas){
		return new MedicionLucesAutomaticasModel(medicionLucesAutomaticas.getIdMedicionLucesAutomaticas(), medicionLucesAutomaticas.isHayPersonas(),medicionLucesAutomaticas.getFechaHora());
	}
	
	public MedicionLucesAutomaticas modelToEntity(MedicionLucesAutomaticasModel medicionLucesAutomaticasModel) {
		return new MedicionLucesAutomaticas(medicionLucesAutomaticasModel.getIdMedicionLucesAutomaticas(), medicionLucesAutomaticasModel.isHayPersonas(),medicionLucesAutomaticasModel.getFechaHora());
	}

}
