package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.validation.constraints.Size;
import com.unla.Grupo16OO22023.entities.MedicionCortina;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoCortinaModel extends DispositivoModel{
	
	private LocalTime aperturaDesde;
	private LocalTime aperturaHasta;
	private List<MedicionCortinaModel> medicionCortina;
	
	public DispositivoCortinaModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja,
			LocalTime aperturaDesde, LocalTime aperturaHasta, List<MedicionCortinaModel> medicionCortina) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.aperturaDesde = aperturaDesde;
		this.aperturaHasta = aperturaHasta;
		this.medicionCortina = medicionCortina;
	}
	
	public DispositivoCortinaModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja) {
		super(idDispositivo, nombre, zona, activo, baja);
	}
	
	
	public DispositivoCortinaModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo,
			boolean baja,
			@Size(min = 3, max = 50, message = "El nombre del aula tiene que tener de 3 a 50 caracteres.")
			List<MedicionCortinaModel> medicionCortina) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.medicionCortina = medicionCortina;
	}



	

}
