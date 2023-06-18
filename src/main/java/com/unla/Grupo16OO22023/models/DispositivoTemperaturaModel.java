package com.unla.Grupo16OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoTemperaturaModel extends DispositivoModel {
	
	private MedicionTemperaturaModel medicionTemperatura;

	public DispositivoTemperaturaModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja,
			MedicionTemperaturaModel medicionTemperatura) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.medicionTemperatura = medicionTemperatura;
	}
	

}
