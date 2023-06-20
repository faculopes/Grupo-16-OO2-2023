package com.unla.Grupo16OO22023.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	

	@Nullable
	@OneToMany(mappedBy = "dispositivoLucesAutomaticas",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicionLucesAutomaticas> medicionesLucesAutomaticas;


	public DispositivoLucesAutomaticas(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			String aula) {
		super(idDispositivo, nombre, zona, activo, baja);
		Aula = aula;
	}


	public DispositivoLucesAutomaticas(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			String aula, List<MedicionLucesAutomaticas> medicionesLucesAutomaticas) {
		super(idDispositivo, nombre, zona, activo, baja);
		Aula = aula;
		this.medicionesLucesAutomaticas = medicionesLucesAutomaticas;
	}

	
	
	
	
	

}
