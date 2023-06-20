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
	private boolean hayLuzNatural;
	private LocalDateTime fechaHora;
	private boolean procesado;
	private boolean lucesPrendidas;
	
	
	public MedicionLucesAutomaticasModel(long idMedicionLucesAutomaticas,
			DispositivoLucesAutomaticasModel dispositivoLucesAutomaticas, boolean hayPersonas, boolean hayLuzNatural,
			LocalDateTime fechaHora, boolean procesado, boolean lucesPrendidas) {
		super();
		this.idMedicionLucesAutomaticas = idMedicionLucesAutomaticas;
		this.dispositivoLucesAutomaticas = dispositivoLucesAutomaticas;
		this.hayPersonas = hayPersonas;
		this.hayLuzNatural = hayLuzNatural;
		this.fechaHora = fechaHora;
		this.procesado = procesado;
		this.lucesPrendidas = lucesPrendidas;
	}
	

	

}
