package com.unla.Grupo16OO22023.models;

import java.time.LocalDateTime;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicionAlumbradoModel {
	
	private long idMedicionAlumbrado;
	private DispositivoAlumbradoModel dispositivoAlumbrado;
	private boolean hayPersonas;
	private boolean hayLuzNatural;
	private LocalDateTime fechaHora;
	private boolean procesado;
	private boolean lucesPrendidas;
	
	
	public MedicionAlumbradoModel(long idMedicionAlumbrado, DispositivoAlumbradoModel dispositivoAlumbrado,
			boolean hayPersonas, boolean hayLuzNatural, LocalDateTime fechaHora, boolean procesado,
			boolean lucesPrendidas) {
		super();
		this.idMedicionAlumbrado = idMedicionAlumbrado;
		this.dispositivoAlumbrado = dispositivoAlumbrado;
		this.hayPersonas = hayPersonas;
		this.hayLuzNatural = hayLuzNatural;
		this.fechaHora = fechaHora;
		this.procesado = procesado;
		this.lucesPrendidas = lucesPrendidas;
	}
	
	

}
