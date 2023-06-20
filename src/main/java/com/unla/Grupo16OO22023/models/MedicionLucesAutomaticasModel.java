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
	private DispositivoLucesAutomaticasModel dispositivoLucesAutomaticas;
	private boolean hayPersonas;
	private boolean hayLuz;
	private LocalDateTime fechaHora;
	private boolean procesado;
	
	public MedicionLucesAutomaticasModel(long idMedicionLucesAutomaticas,
			DispositivoLucesAutomaticasModel dispositivoLucesAutomaticas, boolean hayPersonas, boolean hayLuz,
			LocalDateTime fechaHora, boolean procesado) {
		super();
		this.idMedicionLucesAutomaticas = idMedicionLucesAutomaticas;
		this.dispositivoLucesAutomaticas = dispositivoLucesAutomaticas;
		this.hayPersonas = hayPersonas;
		this.hayLuz = hayLuz;
		this.fechaHora = fechaHora;
		this.procesado = procesado;
	}
	
	

}
