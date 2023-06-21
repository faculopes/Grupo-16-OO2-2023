package com.unla.Grupo16OO22023.repositories;

import org.springframework.stereotype.Repository;

import com.unla.Grupo16OO22023.entities.Evento;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable> {
	public abstract Evento findByidEvento(long id);

}
