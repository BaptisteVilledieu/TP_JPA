/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.dao;

import galerie.entity.Personne;
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
@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class PersonneRepositoryTest {
    @Autowired
    private PersonneRepository personneDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Personne'");
        int combienDansLeJeuDeTest = 5; 
        long nombre = personneDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 5 personnes" );
    }
    
    @Test
    public void onSaitAjouterDesPersonnes(){
        log.info("On ajoute des personnes dans la table Personne");
        //On va creer une personne
        Personne perso = new Personne ("perso","5 rue du perso");
        //On enregistre la personne
        personneDAO.save(perso);
        //On recupere la table Personne
        List<Personne> lesPersonnes = personneDAO.findAll();
        Personne persoRecup = lesPersonnes.get(0);
        
        assertEquals(perso, persoRecup,"Les personnes devraient etre les memes");
        
    }
}
