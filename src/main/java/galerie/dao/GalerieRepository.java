package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Galerie;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring 

public interface GalerieRepository extends JpaRepository<Galerie, Integer> {
    /**
     * Calculer le chiffre d'affaires pour une exposition
     * @param id la clé primaire de l'exposition
     * @return le chiffre d'affaires de cette exposition
     */
    @Query("SELECT SUM(id.prixVente)"
		+ "FROM Transaction t "
		+ "JOIN t.exposition e "
		+ "WHERE e.id = id ")
    float chiffreAffairePour(Integer id);

}
