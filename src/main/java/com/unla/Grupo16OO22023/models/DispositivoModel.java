package com.unla.Grupo16OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class DispositivoModel {
	protected long idDispositivo;
	protected String nombre;
	protected ZonaModel zona;
	protected boolean activo;
	protected boolean baja;
	
	public DispositivoModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja) {
		super();
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.zona = zona;
		this.activo = activo;
		this.baja = baja;
	}

}
