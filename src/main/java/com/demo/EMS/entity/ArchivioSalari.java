package com.demo.EMS.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class ArchivioSalari {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalario;
	@Column(nullable = false)
	private LocalDateTime dataEmissione;
	@Column(nullable = false)
	private LocalDateTime dataInizioVal;
	@Column(nullable = false)
	private LocalDateTime dataFineVal;
	@Column(nullable = false)
	private Double importo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_documento")
	private ArchivioDocumenti documento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dipendente")
	private Dipendente dipendente;

	public ArchivioSalari() {}
	
	public ArchivioSalari(LocalDateTime dataEmissione, LocalDateTime dataInizioVal, LocalDateTime dataFineVal, Double importo, ArchivioDocumenti documento) {
		this.dataEmissione = dataEmissione;
		this.dataInizioVal = dataInizioVal;
		this.dataFineVal = dataFineVal;
		this.importo = importo;
		this.documento = documento;
	}
	
	public Long getIdSalario() {
		return idSalario;
	}

	public void setIdSalario(Long idSalario) {
		this.idSalario = idSalario;
	}



	public LocalDateTime getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDateTime dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public LocalDateTime getDataInizioVal() {
		return dataInizioVal;
	}

	public void setDataInizioVal(LocalDateTime dataInizioVal) {
		this.dataInizioVal = dataInizioVal;
	}

	public LocalDateTime getDataFineVal() {
		return dataFineVal;
	}

	public void setDataFineVal(LocalDateTime dataFineVal) {
		this.dataFineVal = dataFineVal;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public ArchivioDocumenti getDocumento() {
		return documento;
	}

	public void setDocumento(ArchivioDocumenti documento) {
		this.documento = documento;
	}


	
	
	
}
