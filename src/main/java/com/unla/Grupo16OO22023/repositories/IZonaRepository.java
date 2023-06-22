package com.unla.Grupo16OO22023.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.Zona;

@Repository("zonaRepository")
public interface IZonaRepository extends JpaRepository<Zona,Serializable>{

	public abstract Zona findByidZona(long id);
}
