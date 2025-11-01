package com.demo.EMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.EMS.entity.ArchivioDocumenti;
import com.demo.EMS.entity.ArchivioSalari;
import com.demo.EMS.repository.ArchivioSalariRepository;

@Service
public class ArchivioSalariService {

	private ArchivioSalariRepository archivioSalariRepository;
	
	public ArchivioSalariService(ArchivioSalariRepository archivioSalariRepository) {
		this.archivioSalariRepository = archivioSalariRepository;
	}
	
	public void deleteDocumentoById(Long idSalario) {
		this.archivioSalariRepository.deleteById(idSalario);
	}
	
	public void updateSalarioById(Long idSalario, ArchivioSalari nuovoSalario) {
		ArchivioSalari salarioDB = this.archivioSalariRepository.findById(idSalario)
				.orElseThrow(() -> new RuntimeException("Salario non trovato con id " + idSalario));
		salarioDB.setDocumento(nuovoSalario.getDocumento());
		salarioDB.setImporto(nuovoSalario.getImporto());
		salarioDB.setDataEmissione(nuovoSalario.getDataEmissione());
		salarioDB.setDataFineVal(nuovoSalario.getDataFineVal());
		salarioDB.setDataInizioVal(nuovoSalario.getDataInizioVal());
		this.archivioSalariRepository.save(salarioDB);
	}
	
	public void insertSalario(ArchivioSalari nuovoSalario) {
		this.archivioSalariRepository.save(nuovoSalario);
	}
	
	public ArchivioSalari getSalarioById(Long idSalario) {
		return this.archivioSalariRepository.findById(idSalario)
				.orElseThrow(() -> new RuntimeException("Salario non trovato con id " + idSalario));
	}
	
	public List<ArchivioSalari> getAllSalari(){
		return this.archivioSalariRepository.findAll();
	}
	
	
}
