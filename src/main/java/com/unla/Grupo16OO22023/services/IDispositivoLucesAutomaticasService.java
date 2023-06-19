package com.unla.Grupo16OO22023.services;

import java.util.List;

import com.unla.Grupo16OO22023.entities.DispositivoLucesAutomaticas;
import com.unla.Grupo16OO22023.models.DispositivoLucesAutomaticasModel;

public interface IDispositivoLucesAutomaticasService {

	public List<DispositivoLucesAutomaticas> getAll();
	
	public DispositivoLucesAutomaticasModel insertOrUpdate(DispositivoLucesAutomaticasModel dispositivoLucesAutomaticasModel);
	
	public DispositivoLucesAutomaticasModel traerPorId(long id);
	
	public boolean baja(long id);
}
