package com.unla.Grupo16OO22023.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo16OO22023.entities.DispositivoLucesAutomaticas;
import com.unla.Grupo16OO22023.models.DispositivoLucesAutomaticasModel;

@Component("dispositivoLucesAutomaticasConverter")
public class DispositivoLucesAutomaticasConverter {
	
	@Autowired
	@Qualifier("medicionLucesAutomaticasConverter")
	private MedicionLucesAutomaticasConverter medicionLucesAutomaticasConverter;

	@Autowired
	@Qualifier("zonaConverter")
	private ZonaConverter zonaConverter;

	public DispositivoLucesAutomaticasModel entityToModel(DispositivoLucesAutomaticas dispositivoLucesAutomaticas) {
		return new DispositivoLucesAutomaticasModel(dispositivoLucesAutomaticas.getIdDispositivo(), 
				dispositivoLucesAutomaticas.getNombre(), zonaConverter.entityToModel(dispositivoLucesAutomaticas.getZona()),
				dispositivoLucesAutomaticas.isActivo(), dispositivoLucesAutomaticas.isBaja(),dispositivoLucesAutomaticas.getAula() );
	}
	
	public DispositivoLucesAutomaticas modelToEntity(DispositivoLucesAutomaticasModel dispositivoLucesAutomaticasModel) {
		return new DispositivoLucesAutomaticas(dispositivoLucesAutomaticasModel.getIdDispositivo(), 
				dispositivoLucesAutomaticasModel.getNombre(), zonaConverter.modelToEntity(dispositivoLucesAutomaticasModel.getZona()),
				dispositivoLucesAutomaticasModel.isActivo(), dispositivoLucesAutomaticasModel.isBaja(),dispositivoLucesAutomaticasModel.getAula());
	}

}
