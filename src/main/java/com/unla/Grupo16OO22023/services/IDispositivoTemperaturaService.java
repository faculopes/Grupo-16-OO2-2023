package com.unla.Grupo16OO22023.services;
import java.util.List;
import com.unla.Grupo16OO22023.entities.DispositivoTemperatura;
import com.unla.Grupo16OO22023.entities.Evento;
import com.unla.Grupo16OO22023.entities.MedicionTemperatura;
import com.unla.Grupo16OO22023.models.DispositivoTemperaturaModel;

public interface IDispositivoTemperaturaService {

	public List<DispositivoTemperatura> getAll();
	
	public DispositivoTemperaturaModel insertOrUpdate(DispositivoTemperaturaModel dispositivoTemperaturaModel);
	
	public DispositivoTemperaturaModel traerPorId(long id);
	
	public boolean baja(long id);
	
	public Evento crearEvento(MedicionTemperatura medicionTemperatura);
}