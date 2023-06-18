package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicionLucesAutomaticasModel {
	
	private long idMedicionLucesAutomaticas;
	private boolean hayPersonas;
	private LocalDateTime fechaHora;
	
	public MedicionLucesAutomaticasModel(long idMedicionLucesAutomaticas, boolean hayPersonas,
			LocalDateTime fechaHora) {
		super();
		this.idMedicionLucesAutomaticas = idMedicionLucesAutomaticas;
		this.hayPersonas = hayPersonas;
		this.fechaHora = fechaHora;
	}

}
