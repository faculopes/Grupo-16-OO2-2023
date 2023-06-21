package com.unla.Grupo16OO22023.converter;

import org.springframework.stereotype.Component;

import com.unla.Grupo16OO22023.entities.Zona;
import com.unla.Grupo16OO22023.models.ZonaModel;

@Component("zonaConverter")
public class ZonaConverter {
	
	public ZonaModel entityToModel(Zona zona) {
		return new ZonaModel(zona.getIdZona(), zona.getNombre());
	}
	
	public Zona modelToEntity(ZonaModel zonaModel) {
		return new Zona(zonaModel.getIdZona(), zonaModel.getNombre());
	}

}