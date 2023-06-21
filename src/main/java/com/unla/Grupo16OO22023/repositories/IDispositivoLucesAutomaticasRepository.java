package com.unla.Grupo16OO22023.repositories;

import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.DispositivoLucesAutomaticas;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("dispositivoLucesAutomaticasRepository")
public interface IDispositivoLucesAutomaticasRepository extends JpaRepository<DispositivoLucesAutomaticas, Serializable>{
	public abstract DispositivoLucesAutomaticas findByidDispositivo(long id);
	public abstract DispositivoLucesAutomaticas findByNombre(String nombre);
	public abstract DispositivoLucesAutomaticas findByZona(int idZona);

}
