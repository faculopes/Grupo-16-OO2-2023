package com.unla.Grupo16OO22023.repositories;
import org.springframework.stereotype.Repository;
import com.unla.Grupo16OO22023.entities.MedicionTemperatura;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("medicionTemperaturaRepository")
public interface IMedicionesTemperaturaRepository extends JpaRepository<MedicionTemperatura, Serializable> {
	public abstract MedicionTemperatura findByidMedicionTemperatura(int id);
	public abstract MedicionTemperatura findTopByOrderByIdMedicionTemperaturaDesc();
}
