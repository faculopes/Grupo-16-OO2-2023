package com.unla.Grupo16OO22023.repositories;
import org.springframework.stereotype.Repository;
import com.unla.Grupo16OO22023.entities.MedicionCortina;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("medicionCortinaRepository")
public interface IMedicionCortinaRepository extends JpaRepository<MedicionCortina, Serializable> {
	public abstract MedicionCortina findByidMedicionCortina(int id);
	public abstract MedicionCortina findTopByOrderByIdMedicionCortinaDesc();
}
