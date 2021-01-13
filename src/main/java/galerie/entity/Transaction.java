/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Transaction {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @NonNull
    private LocalDate venduLe;
    
    private float prixVente;
    
    @ManyToOne
    private Exposition lieuDeVente;
    
    @ManyToOne
    private Personne client;
    
    @OneToOne(mappedBy="vendu")
    private Tableau oeuvre;
    
    

}
