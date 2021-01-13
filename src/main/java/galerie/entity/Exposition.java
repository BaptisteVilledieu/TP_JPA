/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author bapti
 */
    @Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
    @Entity 
public class Exposition {
    

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @NonNull
    private LocalDate debut;
    
    @NonNull
    private String intitule;
    
    private int duree;
    
    public float CA(){
        float calculCA=0;
        for(Transaction t:ventes){
            calculCA += t.getPrixVente();
        }
        return calculCA;       
    }
    @ManyToOne
    private Galerie organisateur;
    
    @OneToMany(mappedBy = "lieuDeVente")
    private List<Transaction> ventes = new LinkedList<>();
    
    @ManyToMany
    List<Tableau> oeuvres = new LinkedList<>();
    
    
}
