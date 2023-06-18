package com.unla.Grupo16OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoLucesAutomaticasModel extends DispositivoModel {
	
	private MedicionLucesAutomaticasModel medicionLucesAutomaticas;

	public DispositivoLucesAutomaticasModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja,
			MedicionLucesAutomaticasModel medicionLucesAutomaticas) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.medicionLucesAutomaticas = medicionLucesAutomaticas;
	}

}
