package com.unla.Grupo16OO22023.services;
import java.util.List;
import com.unla.Grupo16OO22023.entities.DispositivoCortina;
import com.unla.Grupo16OO22023.entities.Evento;
import com.unla.Grupo16OO22023.entities.MedicionCortina;
import com.unla.Grupo16OO22023.models.DispositivoCortinaModel;

public interface IDispositivoCortinaService {

	public List<DispositivoCortina> getAll();
	
	public DispositivoCortinaModel insertOrUpdate(DispositivoCortinaModel dispositivoCortinaModel);
	
	public DispositivoCortinaModel traerPorId(long id);
	
	public boolean baja(long id);
	
	public Evento crearEvento(MedicionCortina medicionCortina);
}