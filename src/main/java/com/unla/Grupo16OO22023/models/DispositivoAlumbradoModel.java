package com.unla.Grupo16OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoAlumbradoModel extends DispositivoModel{
	
	private MedicionAlumbradoModel medicionAlimbrado;

	public DispositivoAlumbradoModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja,
			MedicionAlumbradoModel medicionAlimbrado) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.medicionAlimbrado = medicionAlimbrado;
	}
	
	
	

}
