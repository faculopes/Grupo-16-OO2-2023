package com.unla.Grupo16OO22023.models;

import java.util.List;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoAlumbradoModel extends DispositivoModel{
	
	
	
	@Size(min=2,max=50,message="El nombre de la Plaza tiene que tener entre 3 y 50 caracteres.")
	private String metros;
	
	private List<MedicionAlumbradoModel> medicionesAlumbrado;

	public DispositivoAlumbradoModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo,
			boolean baja,
			@Size(min = 3, max = 50, message = "El nombre de la Plaza tiene que tener entre 3 y 50 caracteres.") String metros,
			List<MedicionAlumbradoModel> medicionesAlumbrado) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.metros=metros;
		this.medicionesAlumbrado = medicionesAlumbrado;
	}
	
	public DispositivoAlumbradoModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja,String metros
			) {
		super(idDispositivo, nombre, zona, activo, baja);
		
		this.metros=metros;
	}
	

}
