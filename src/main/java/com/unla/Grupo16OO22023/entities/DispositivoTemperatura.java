package com.unla.Grupo16OO22023.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="dispositivoTemperatura")
@PrimaryKeyJoinColumn(name = "idDispositivoTemperatura")
public class DispositivoTemperatura extends Dispositivo{
	
	@ManyToOne
	@JoinColumn(name = "idMedicionTemperatura")
	private MedicionTemperatura medicionTemperatura;

	public DispositivoTemperatura(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			MedicionTemperatura medicionTemperatura) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.medicionTemperatura = medicionTemperatura;
	}


}
