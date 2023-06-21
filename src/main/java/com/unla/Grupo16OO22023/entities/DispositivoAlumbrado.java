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
@Table(name="dispositivoAlumbrado")
@PrimaryKeyJoinColumn(name = "idDispositivoAlumbrado")
public class DispositivoAlumbrado extends Dispositivo{
	
	@ManyToOne
	@JoinColumn(name = "idMedicionAlumbrado")
	private MedicionAlumbrado medicionAlumbrado;

	public DispositivoAlumbrado(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			MedicionAlumbrado medicionAlumbrado) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.medicionAlumbrado = medicionAlumbrado;
	}

}
