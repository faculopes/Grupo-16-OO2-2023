package com.unla.Grupo16OO22023.repositories;


import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.MedicionAlumbrado;

@Repository("medicionAlumbradoRepository")
public interface IMedicionAlumbradoRepository  extends JpaRepository<MedicionAlumbrado,Serializable>{

	public abstract MedicionAlumbrado findByidMedicionAlumbrado(long id);
	public abstract MedicionAlumbrado findTopByOrderByIdMedicionAlumbradoDesc();
}
