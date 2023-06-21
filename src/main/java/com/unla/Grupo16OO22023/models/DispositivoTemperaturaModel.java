package com.unla.Grupo16OO22023.models;

import java.util.List;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoTemperaturaModel extends DispositivoModel {
	
	private int calorExcesivo = 70;
	
	boolean aireAcondicionado;
	@Size(min=3,max=50,message="El nombre del aula tiene que tener de 3 a 50 caracteres.")
	private String Aula;
	
	private List<MedicionTemperaturaModel> medicionesTemperatura;

	public DispositivoTemperaturaModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja,
			int calorExcesivo, boolean aireAcondicionado, String aula, List<MedicionTemperaturaModel> medicionesTemperatura) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.calorExcesivo = calorExcesivo;
		this.aireAcondicionado = aireAcondicionado;
		Aula = aula;
		this.medicionesTemperatura = medicionesTemperatura;
	}

	public DispositivoTemperaturaModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja, boolean aireAcondicionado, String aula) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.aireAcondicionado = aireAcondicionado;
		Aula = aula;
	}

	public DispositivoTemperaturaModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo,
			boolean baja,
			@Size(min = 3, max = 50, message = "El nombre del aula tiene que tener de 3 a 50 caracteres.") String aula,
			List<MedicionTemperaturaModel> medicionesTemperatura) {
		super(idDispositivo, nombre, zona, activo, baja);
		Aula = aula;
		this.medicionesTemperatura = medicionesTemperatura;
	}





	

	
	

}