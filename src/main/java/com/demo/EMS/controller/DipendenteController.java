package com.demo.EMS.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.demo.EMS.entity.Dipendente;
import com.demo.EMS.entity.TipoRuolo;
import com.demo.EMS.service.DipendenteService;
import com.demo.EMS.service.DipartimentoService;

@Controller
public class DipendenteController {
	
	private DipendenteService dipendenteService;
	private DipartimentoService dipartimentoService;
	
	public DipendenteController(DipendenteService dipendenteService, DipartimentoService dipartimentoService) {
		this.dipendenteService = dipendenteService;
		this.dipartimentoService = dipartimentoService;
	}
	
	@GetMapping("/dipendenti")
	public String getAllDipendenti(
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "ruolo", required = false) String ruoloStr,
			@RequestParam(value = "dipartimento", required = false) Long dipartimentoId,
			Model model) {
		
		List<Dipendente> dipendenti;
		
		// Converti la stringa in enum
		TipoRuolo ruolo = null;
		if (ruoloStr != null && !ruoloStr.isEmpty()) {
			try {
				ruolo = TipoRuolo.valueOf(ruoloStr);
			} catch (IllegalArgumentException e) {
				// Valore non valido, ignora
			}
		}
		
		// Se ci sono filtri o ricerca, usa la query con filtri
		if ((search != null && !search.trim().isEmpty()) || 
		    ruolo != null || 
		    dipartimentoId != null) {
			dipendenti = this.dipendenteService.searchWithFilters(search, ruolo, dipartimentoId);
		} else {
			// Altrimenti mostra tutti
			dipendenti = this.dipendenteService.getAllDipendenti();
		}
		
		// Passa i dati al template
		model.addAttribute("dipendenti", dipendenti);
		model.addAttribute("search", search);
		model.addAttribute("selectedRuolo", ruoloStr);
		model.addAttribute("selectedDipartimento", dipartimentoId);
		
		// Lista di tutti i ruoli e dipartimenti disponibili per i dropdown
		model.addAttribute("ruoli", this.dipendenteService.getAllRuoli());
		model.addAttribute("dipartimenti", this.dipartimentoService.getAllDipartimenti());
		
		return "dipendenti";
	}
	
	@GetMapping("/dipendenti/elimina/{idDipendente}")
	public String eliminaDipendenteById(@PathVariable Long idDipendente, RedirectAttributes redirectAttributes) {
		this.dipendenteService.deleteDipendenteByID(idDipendente);
		redirectAttributes.addFlashAttribute("success", "Dipendente eliminato");
		return "redirect:/dipendenti";
	}
	
}