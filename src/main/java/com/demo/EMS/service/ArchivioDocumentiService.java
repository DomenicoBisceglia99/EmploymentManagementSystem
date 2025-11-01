package com.demo.EMS.service;

import java.time.LocalDateTime;
import java.util.List;
import com.demo.EMS.repository.ArchivioSalariRepository;
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
		documentoDB.setDataOraSalvataggio(LocalDateTime.now());
		documentoDB.setDipendente(nuovoDocumento.getDipendente());
		documentoDB.setFilePath(nuovoDocumento.getFilePath());
		documentoDB.setTipoDocumento(nuovoDocumento.getTipoDocumento());
		this.archivioDocumentiRepository.save(documentoDB);
	}
	
	public void insertDocumento(ArchivioDocumenti nuovoDocumento) {
		nuovoDocumento.setDataOraSalvataggio(LocalDateTime.now());
		this.archivioDocumentiRepository.save(nuovoDocumento);
	}
	
	public ArchivioDocumenti getDocumentoById(Long idDocumento) {
		return this.archivioDocumentiRepository.findById(idDocumento) 
				.orElseThrow(() -> new RuntimeException("Documento non trovato con id " + idDocumento));
	}
	
	public List<ArchivioDocumenti> getAllDocumenti(){
		return this.archivioDocumentiRepository.findAll();			
	}
	
}
