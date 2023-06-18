package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicionAlumbradoModel {
	
	private long idMedicionAlumbrado;
	private boolean hayPersonas;
	private LocalDateTime fechaHora;
	
	public MedicionAlumbradoModel(long idMedicionAlumbrado, boolean hayPersonas, LocalDateTime fechaHora) {
		super();
		this.idMedicionAlumbrado = idMedicionAlumbrado;
		this.hayPersonas = hayPersonas;
		this.fechaHora = fechaHora;
	}

}
