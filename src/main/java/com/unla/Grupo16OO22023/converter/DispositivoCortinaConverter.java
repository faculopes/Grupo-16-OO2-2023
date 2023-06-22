package com.unla.Grupo16OO22023.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo16OO22023.entities.DispositivoCortina;
import com.unla.Grupo16OO22023.models.DispositivoCortinaModel;


@Component("dispositivoCortinaConverter")
public class DispositivoCortinaConverter {

	@Autowired
	@Qualifier("zonaConverter")
	private ZonaConverter zonaConverter;

	public DispositivoCortinaModel entityToModel(DispositivoCortina dispositivoCortina) {
		return new DispositivoCortinaModel(dispositivoCortina.getIdDispositivo(), 
				dispositivoCortina.getNombre(), zonaConverter.entityToModel(dispositivoCortina.getZona()),
				dispositivoCortina.isActivo(), dispositivoCortina.isBaja() );
	}
	
	public DispositivoCortina modelToEntity(DispositivoCortinaModel dispositivoCortinaModel) {
		return new DispositivoCortina(dispositivoCortinaModel.getIdDispositivo(), 
				dispositivoCortinaModel.getNombre(), zonaConverter.modelToEntity(dispositivoCortinaModel.getZona()),
				dispositivoCortinaModel.isActivo(), dispositivoCortinaModel.isBaja());
	}

}