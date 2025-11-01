package com.demo.EMS.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Presenze {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_presenza")
	private Long idPresenza;
	@Column(nullable = false)
	private LocalDateTime dataInizioTurno;
	@Column(nullable = false)
	private LocalDateTime dataFineTurno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_dipendente")
	private Dipendente dipendente;

	public Presenze() {}
	
	public Presenze(LocalDateTime dataInizioTurno, LocalDateTime dataFineTurno, Dipendente dipendente) {
		this.dataInizioTurno = dataInizioTurno;
		this.dataFineTurno = dataFineTurno;
		this.dipendente = dipendente;
	}
	
	public Long getIdPresenza() {
		return idPresenza;
	}

	public void setIdPresenza(Long idPresenza) {
		this.idPresenza = idPresenza;
	}

	public LocalDateTime getDataInizioTurno() {
		return dataInizioTurno;
	}

	public void setDataInizioTurno(LocalDateTime dataInizioTurno) {
		this.dataInizioTurno = dataInizioTurno;
	}

	public LocalDateTime getDataFineTurno() {
		return dataFineTurno;
	}

	public void setDataFineTurno(LocalDateTime dataFineTurno) {
		this.dataFineTurno = dataFineTurno;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
	
	
	
}
