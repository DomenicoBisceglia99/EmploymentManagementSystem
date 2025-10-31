package com.demo.EMS.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.demo.EMS.entity.ArchivioDocumenti;
import com.demo.EMS.repository.ArchivioDocumentiRepository;

@Service
public class ArchivioDocumentiService {
	private ArchivioDocumentiRepository archivioDocumentiRepository;
	
	public ArchivioDocumentiService(ArchivioDocumentiRepository archivioDocumentiRepository) {
		this.archivioDocumentiRepository = archivioDocumentiRepository;
	}
	
	public void deleteDocumentoById(Long idDocumento) {
		this.archivioDocumentiRepository.deleteById(idDocumento);
	}
	
	public void updateDocumentoById(Long idDocumento, ArchivioDocumenti nuovoDocumento) {
		ArchivioDocumenti documentoDB = this.archivioDocumentiRepository.findById(idDocumento) 
				.orElseThrow(() -> new RuntimeException("Documento non trovato con id " + idDocumento));
		documentoDB.setDataOraSalvataggio(nuovoDocumento.getDataOraSalvataggio());
	}
	
	public void insertDocumento(ArchivioDocumenti nuovoDocumento) {
		nuovoDocumento.setDataOraSalvataggio(LocalDateTime.now());
		this.archivioDocumentiRepository.save(nuovoDocumento);
	}
	
}
