package com.unla.Grupo16OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ZonaModel {
	
	private long idZona;
	private String nombre;
	
	public ZonaModel(long idZona, String nombre) {
		super();
		this.idZona = idZona;
		this.nombre = nombre;
	}
	

}
