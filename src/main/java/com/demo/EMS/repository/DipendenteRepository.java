package com.demo.EMS.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.EMS.entity.Dipendente;
import com.demo.EMS.entity.TipoRuolo;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
	
	@Query("SELECT d FROM Dipendente d WHERE " +
	       "LOWER(d.nome) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	       "LOWER(d.cognome) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	       "LOWER(d.codiceFiscale) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Dipendente> searchDipendenti(@Param("keyword") String keyword);
	
	// Query con filtri multipli
	@Query("SELECT d FROM Dipendente d WHERE " +
	       "(:keyword IS NULL OR :keyword = '' OR " +
	       "LOWER(d.nome) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	       "LOWER(d.cognome) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	       "LOWER(d.codiceFiscale) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
	       "(:ruolo IS NULL OR d.ruolo = :ruolo) AND " +
	       "(:dipartimentoId IS NULL OR d.dipartimento.idDipartimento = :dipartimentoId)")
	List<Dipendente> searchWithFilters(
	    @Param("keyword") String keyword,
	    @Param("ruolo") TipoRuolo ruolo,
	    @Param("dipartimentoId") Long dipartimentoId
	);
	
	// Query per ottenere tutti i ruoli distinti
	@Query("SELECT DISTINCT d.ruolo FROM Dipendente d WHERE d.ruolo IS NOT NULL ORDER BY d.ruolo")
	List<TipoRuolo> findAllDistinctRuoli();
}