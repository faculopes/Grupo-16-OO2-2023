package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventoModel {
	private long idEvento;
	private String descripcion;
	private DispositivoModel dispositivo;
	private LocalDateTime fechaHora;
	
	public EventoModel(long idEvento, String descripcion, DispositivoModel dispositivo, LocalDateTime fechaHora) {
		super();
		this.idEvento = idEvento;
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
		this.fechaHora = fechaHora;
	}
	

}
