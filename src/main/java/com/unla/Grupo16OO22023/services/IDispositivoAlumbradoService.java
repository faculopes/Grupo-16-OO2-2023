package com.unla.Grupo16OO22023.services;

import java.util.List;

import com.unla.Grupo16OO22023.entities.DispositivoAlumbrado;
import com.unla.Grupo16OO22023.entities.Evento;
import com.unla.Grupo16OO22023.entities.MedicionAlumbrado;
import com.unla.Grupo16OO22023.models.DispositivoAlumbradoModel;

public interface IDispositivoAlumbradoService {

	public List<DispositivoAlumbrado> getAll();
	
	public DispositivoAlumbradoModel insertOrUpdate(DispositivoAlumbradoModel dispositivoAlumbradoModelo);
	
	public boolean remove(long id);
	
	public DispositivoAlumbradoModel traerPorId(long id);
	
	public Evento crearEvento(MedicionAlumbrado medicionAlumbrado);
}
