package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DispositivoCortinaModel extends DispositivoModel{
	
	private LocalDateTime aperturaDesde;
	private LocalDateTime aperturaHasta;
	private MedicionCortinaModel medicionCortina;
	
	public DispositivoCortinaModel(long idDispositivo, String nombre, ZonaModel zona, boolean activo, boolean baja,
			LocalDateTime aperturaDesde, LocalDateTime aperturaHasta, MedicionCortinaModel medicionCortina) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.aperturaDesde = aperturaDesde;
		this.aperturaHasta = aperturaHasta;
		this.medicionCortina = medicionCortina;
	}

}
