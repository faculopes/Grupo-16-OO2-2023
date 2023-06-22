package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicionTemperaturaModel {
	
	private long idMedicionTemperatura;
	private boolean tempAlta;
	private LocalDateTime fechaHora;
	private boolean procesado;
	public MedicionTemperaturaModel(long idMedicionTemperatura, boolean tempAlta, LocalDateTime fechaHora,
			boolean procesado) {
		super();
		this.idMedicionTemperatura = idMedicionTemperatura;
		this.tempAlta = tempAlta;
		this.fechaHora = fechaHora;
		this.procesado = procesado;
	}
}
