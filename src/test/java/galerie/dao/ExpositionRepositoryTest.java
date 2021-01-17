/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.dao;

import galerie.entity.Exposition;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

/**
 *
 * @author bapti
 */
@Log4j2 
@DataJpaTest
public class ExpositionRepositoryTest {

    @Autowired
    private ExpositionRepository expositionDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Exposition'");
        int combienDansLeJeuDeTest = 2; 
        long nombre = expositionDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 2 Expositions" );
    }
        @Test 
    public void onSaitAjouterUneGalerie(){
        log.info("On ajoute une galerie à la table 'Galerie'");
        //On crée une Exposition
        Exposition exposition = new Exposition(LocalDate.now(),"5 rue de l'eglise, Castres");
        //On enregistre l'exposition 
        expositionDAO.save(exposition);
        //On recupere la table Exposition
        List<Exposition> lesExpositions = expositionDAO.findAll();
        Exposition expositionRecup = lesExpositions.get(0);
        
        assertEquals(exposition, expositionRecup,"Les personnes devraient etre les memes");
    }
}
