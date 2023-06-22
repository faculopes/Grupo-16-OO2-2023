package com.unla.Grupo16OO22023.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo16OO22023.entities.DispositivoAlumbrado;
import com.unla.Grupo16OO22023.models.DispositivoAlumbradoModel;

@Component("dispositivoAlumbradoConverter")
public class DispositivoAlumbradoConverter {
	
	@Autowired
	@Qualifier("zonaConverter")
	private ZonaConverter zonaConverter;

	public DispositivoAlumbradoModel entityToModel(DispositivoAlumbrado dispositivoAlumbrado) {
		
		return new DispositivoAlumbradoModel(dispositivoAlumbrado.getIdDispositivo(),dispositivoAlumbrado.getNombre(),
				zonaConverter.entityToModel(dispositivoAlumbrado.getZona()),dispositivoAlumbrado.isActivo(),dispositivoAlumbrado.isBaja(),dispositivoAlumbrado.getMetros());
	}
	
	public DispositivoAlumbrado modelToEntity(DispositivoAlumbradoModel dispositivoAlumbradoModel) {
		
		return new DispositivoAlumbrado(dispositivoAlumbradoModel.getIdDispositivo(),dispositivoAlumbradoModel.getNombre(),
			zonaConverter.modelToEntity(dispositivoAlumbradoModel.getZona()),dispositivoAlumbradoModel.isActivo(),dispositivoAlumbradoModel.isBaja(),dispositivoAlumbradoModel.getMetros());
	}
}

