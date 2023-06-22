package com.unla.Grupo16OO22023.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
@Table(name="dispositivoCortina")
@PrimaryKeyJoinColumn(name = "idDispositivoCortina")
public class DispositivoCortina extends Dispositivo{
	
	@Column
	private LocalTime aperturaDesde = LocalTime.of(8, 00);
	
	@Column
	private LocalTime aperturaHasta = LocalTime.of(22, 00);
	
	@Nullable 
	@OneToMany(mappedBy = "dispositivoCortina", cascade = CascadeType.ALL)
	private List<MedicionCortina> medicionCortina;


	public DispositivoCortina(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			LocalTime aperturaDesde, LocalTime aperturaHasta, List<MedicionCortina> medicionCortina) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.aperturaDesde = aperturaDesde;
		this.aperturaHasta = aperturaHasta;
		this.medicionCortina = medicionCortina;
	}

	public DispositivoCortina(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja) {
		super(idDispositivo, nombre, zona, activo, baja);
	}
	

}