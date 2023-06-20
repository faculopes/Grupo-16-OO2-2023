package com.unla.Grupo16OO22023.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

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
	
	@Column
	private String Aula;
	
	@ManyToOne
	@JoinColumn(name = "idMedicionLucesAutomaticas")
	@Nullable
	private MedicionLucesAutomaticas medicionLucesAutomaticas;

	public DispositivoLucesAutomaticas(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			@Nullable MedicionLucesAutomaticas medicionLucesAutomaticas) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.medicionLucesAutomaticas = medicionLucesAutomaticas;
	}

	public DispositivoLucesAutomaticas(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			String aula) {
		super(idDispositivo, nombre, zona, activo, baja);
		Aula = aula;
	}

	
	
	
	
	

}
