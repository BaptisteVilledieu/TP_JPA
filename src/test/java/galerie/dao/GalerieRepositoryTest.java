package galerie.dao;

import galerie.entity.Galerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.GalerieRepository;
import java.util.List;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class GalerieRepositoryTest {

    @Autowired
    private GalerieRepository galerieDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Galerie'");
        int combienDansLeJeuDeTest = 2; 
        long nombre = galerieDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver  galerie" );
    }
    
    @Test 
    public void onSaitAjouterUneGalerie(){
        log.info("On ajoute une galerie à la table 'Galerie'");
        //On crée une Galerie
        Galerie galerie = new Galerie("Musée Goya","5 rue de l'eglise, Castres");
        //On enregistre la galerie 
        galerieDAO.save(galerie);
        //On recupere la table Galerie
        List<Galerie> lesGaleries = galerieDAO.findAll();
        Galerie galerieRecup = lesGaleries.get(0);
        
        assertEquals(galerie, galerieRecup,"Les galeries devraient etre les memes");
    }

}
