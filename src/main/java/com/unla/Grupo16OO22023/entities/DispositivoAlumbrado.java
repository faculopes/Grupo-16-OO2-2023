package com.unla.Grupo16OO22023.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="dispositivoAlumbrado")
@PrimaryKeyJoinColumn(name = "idDispositivoAlumbrado")
public class DispositivoAlumbrado extends Dispositivo{
	
	@Column
	private String metros;
	
	@Nullable
	@OneToMany(mappedBy="dispositivoAlumbrado",cascade = CascadeType.ALL)
	private List<MedicionAlumbrado> medicionesAlumbrado;

	public DispositivoAlumbrado(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			String metros) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.metros=metros;
	}

	public DispositivoAlumbrado(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			String metros, List<MedicionAlumbrado> medicionesAlumbrado) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.metros = metros;
		this.medicionesAlumbrado = medicionesAlumbrado;
	}
	

}
