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
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("unused")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="dispositivoTemperatura")
@PrimaryKeyJoinColumn(name = "idDispositivoTemperatura")// falta asignar referencedColumnName
public class DispositivoTemperatura extends Dispositivo{
	
	@Column(name="calorExcesivo")
	private int calorExcesivo = 70; //Esta variable es fija, si temp es igual o mayor es peligroso
	
	@Column(name="estado")
	boolean aireAcondicionado; //Nos permite saber si el aire esta prendido o apagado
	
	@Column(name="aula")
	@Size(min=3,max=50,message="El nombre del aula tiene que tener de 3 a 50 caracteres.")
	private String Aula;
	
	@Nullable 
	@OneToMany(mappedBy = "dispositivoTemperatura", cascade = CascadeType.ALL)
	private List<MedicionTemperatura> medicionTemperatura;

	public DispositivoTemperatura(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja,
			int calorExcesivo, boolean aireAcondicionado, String aula, List<MedicionTemperatura> medicionTemperatura) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.calorExcesivo = calorExcesivo;
		this.aireAcondicionado = aireAcondicionado;
		Aula = aula;
		this.medicionTemperatura = medicionTemperatura;
	}
	
	public DispositivoTemperatura(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja, boolean aireAcondicionado, String aula) {
		super(idDispositivo, nombre, zona, activo, baja);
		this.aireAcondicionado = aireAcondicionado;
		Aula = aula;
	}	
}
