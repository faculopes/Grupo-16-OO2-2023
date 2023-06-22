package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicionCortinaModel {
	
	private long idMedicionCortina;
	private LocalDateTime fechaHora;
	
	public MedicionCortinaModel(long idMedicionCortina, LocalDateTime fechaHora) {
		super();
		this.idMedicionCortina = idMedicionCortina;
		this.fechaHora = fechaHora;
	}


}