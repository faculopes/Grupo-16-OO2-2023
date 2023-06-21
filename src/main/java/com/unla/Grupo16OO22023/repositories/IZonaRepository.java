package com.unla.Grupo16OO22023.repositories;

import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.Zona;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("zonaRepository")
public interface IZonaRepository extends JpaRepository<Zona, Serializable>{
	
	public abstract Zona findByidZona(long id);

}