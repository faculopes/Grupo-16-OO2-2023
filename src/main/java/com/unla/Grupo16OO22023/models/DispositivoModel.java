package com.unla.Grupo16OO22023.models;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class DispositivoModel {
	protected long idDispositivo;
	@Size(min=3,max=50,message="El nombre del dispositivo tiene que tener de 3 a 50 caracteres.")
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
