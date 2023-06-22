package com.unla.Grupo16OO22023.repositories;
import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.DispositivoCortina;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("dispositivoCortinaRepository")
public interface IDispositivoCortinaRepository extends JpaRepository<DispositivoCortina, Serializable>{
	public abstract DispositivoCortina findByidDispositivo(long id);
	public abstract DispositivoCortina findByNombre(String nombre);
	public abstract DispositivoCortina findByZona(int idZona);

}
