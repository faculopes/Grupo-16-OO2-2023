package com.unla.Grupo16OO22023.services;

import java.util.List;

import com.unla.Grupo16OO22023.entities.Zona;
import com.unla.Grupo16OO22023.models.ZonaModel;

public interface IZonaService {
	
	public List<Zona> getAll();
	
	public ZonaModel getById(Long id);

}
