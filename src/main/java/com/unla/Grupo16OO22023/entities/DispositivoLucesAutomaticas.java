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
@Table(name="dispositivoLucesAutomaticas")
@PrimaryKeyJoinColumn(name = "idDispositivoLucesAutomaticas")
public class DispositivoLucesAutomaticas extends Dispositivo{
	

	@ManyToOne
	@JoinColumn(name = "idMedicionLucesAutomaticas")
	private MedicionLucesAutomaticas medicionLucesAutomaticas;

	public DispositivoLucesAutomaticas(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			MedicionLucesAutomaticas medicionLucesAutomaticas) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.medicionLucesAutomaticas = medicionLucesAutomaticas;
	}

}
