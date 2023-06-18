package com.unla.Grupo16OO22023.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
@Table(name="dispositivoCortina")
@PrimaryKeyJoinColumn(name = "idDispositivoCortina")
public class DispositivoCortina extends Dispositivo{
	
	@Column
	private LocalDateTime aperturaDesde;
	
	@Column
	private LocalDateTime aperturaHasta;
	
	@ManyToOne
	@JoinColumn(name = "idMedicionCortina")
	private MedicionCortina medicionCortina;

	public DispositivoCortina(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			LocalDateTime aperturaDesde, LocalDateTime aperturaHasta, MedicionCortina medicionCortina) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.aperturaDesde = aperturaDesde;
		this.aperturaHasta = aperturaHasta;
		this.medicionCortina = medicionCortina;
	}


}
