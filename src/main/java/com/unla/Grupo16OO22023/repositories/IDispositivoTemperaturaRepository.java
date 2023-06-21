package com.unla.Grupo16OO22023.repositories;
import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.DispositivoTemperatura;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("dispositivoTemperaturaRepository")
public interface IDispositivoTemperaturaRepository extends JpaRepository<DispositivoTemperatura, Serializable>{
	public abstract DispositivoTemperatura findByidDispositivo(long id);
	public abstract DispositivoTemperatura findByNombre(String nombre);
	public abstract DispositivoTemperatura findByZona(int idZona);

}
