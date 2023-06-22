package com.unla.Grupo16OO22023.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.DispositivoAlumbrado;

@Repository("dispositivoAlumbradoRepository")
public interface IDispositivoAlumbradoRepository extends 
                                    JpaRepository<DispositivoAlumbrado,Serializable>{

	public abstract DispositivoAlumbrado findByidDispositivo(long idDispositivo);
	public abstract DispositivoAlumbrado findByNombre(String nombre);
	public abstract DispositivoAlumbrado findByZona(long idZona);
	public abstract DispositivoAlumbrado findByActivo(boolean activo);
}
