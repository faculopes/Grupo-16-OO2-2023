package com.unla.Grupo16OO22023.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo16OO22023.entities.DispositivoTemperatura;
import com.unla.Grupo16OO22023.models.DispositivoTemperaturaModel;


@Component("dispositivoTemperaturaConverter")
public class DispositivoTemperaturaConverter {

	@Autowired
	@Qualifier("zonaConverter")
	private ZonaConverter zonaConverter;

	public DispositivoTemperaturaModel entityToModel(DispositivoTemperatura dispositivoTemperatura) {
		return new DispositivoTemperaturaModel(dispositivoTemperatura.getIdDispositivo(), 
				dispositivoTemperatura.getNombre(), zonaConverter.entityToModel(dispositivoTemperatura.getZona()),
				dispositivoTemperatura.isActivo(), dispositivoTemperatura.isBaja(), dispositivoTemperatura.isAireAcondicionado(), dispositivoTemperatura.getAula() );
	}
	
	public DispositivoTemperatura modelToEntity(DispositivoTemperaturaModel dispositivoTemperaturaModel) {
		return new DispositivoTemperatura(dispositivoTemperaturaModel.getIdDispositivo(), 
				dispositivoTemperaturaModel.getNombre(), zonaConverter.modelToEntity(dispositivoTemperaturaModel.getZona()),
				dispositivoTemperaturaModel.isActivo(), dispositivoTemperaturaModel.isBaja(), dispositivoTemperaturaModel.isAireAcondicionado(), dispositivoTemperaturaModel.getAula() );
	}

}