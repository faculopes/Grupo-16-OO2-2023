package com.unla.Grupo16OO22023.models;

import java.util.List;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoLucesAutomaticasModel extends DispositivoModel {
	
	@Size(min=2,max=50,message="El nombre del aula tiene que tener entre 3 y 50 caracteres.")
	private String Aula;
	
	private List<MedicionLucesAutomaticasModel> medicionesLucesAutomaticas;

	public DispositivoLucesAutomaticasModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo,
			boolean baja, String aula, List<MedicionLucesAutomaticasModel> medicionesLucesAutomaticas) {
		super(idDispositivo, nombre, zona, activo, baja);
		Aula = aula;
		this.medicionesLucesAutomaticas = medicionesLucesAutomaticas;
	}

	public DispositivoLucesAutomaticasModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo,
			boolean baja, String aula) {
		super(idDispositivo, nombre, zona, activo, baja);
		Aula = aula;
	}






	
	

}
