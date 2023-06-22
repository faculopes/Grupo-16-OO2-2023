package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicionCortinaModel {
	
	private long idMedicionCortina;
	private LocalDateTime fechaHora;
	private LocalTime hora;
	private boolean procesado;
	
	public MedicionCortinaModel(long idMedicionCortina, LocalDateTime fechaHora, LocalTime hora, boolean procesado) {
		super();
		this.idMedicionCortina = idMedicionCortina;
		this.fechaHora = fechaHora;
		this.hora = hora;
		this.procesado = procesado;
	}


}