package com.unla.Grupo16OO22023.repositories;

import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.MedicionLucesAutomaticas;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("medicionLucesAutomaticasRepository")
public interface IMedicionLucesAutomaticasRepository extends JpaRepository<MedicionLucesAutomaticas, Serializable> {
	
	public abstract MedicionLucesAutomaticas findByidMedicionLucesAutomaticas(int id);

}
