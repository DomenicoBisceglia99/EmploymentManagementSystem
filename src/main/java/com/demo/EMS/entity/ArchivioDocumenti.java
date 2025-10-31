package com.demo.EMS.entity;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class ArchivioDocumenti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocumento;
	
	private LocalDateTime dataOraSalvataggio;
	
	private TipoDocumento tipoDocumento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dipendente")
	private Dipendente dipendente;
	
	private String filePath;
	
	@OneToMany(mappedBy = "documento", cascade = CascadeType.ALL)
	private List<ArchivioSalari> archivioSalari;

	public ArchivioDocumenti() {}
	public ArchivioDocumenti(TipoDocumento tipoDocumento, String filePath) {
		this.tipoDocumento = tipoDocumento;
		this.filePath = filePath;
	}
	
	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}


	public LocalDateTime getDataOraSalvataggio() {
		return dataOraSalvataggio;
	}
	public void setDataOraSalvataggio(LocalDateTime dataOraSalvataggio) {
		this.dataOraSalvataggio = dataOraSalvataggio;
	}
	public List<ArchivioSalari> getArchivioSalari() {
		return archivioSalari;
	}
	public void setArchivioSalari(List<ArchivioSalari> archivioSalari) {
		this.archivioSalari = archivioSalari;
	}
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipentente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
