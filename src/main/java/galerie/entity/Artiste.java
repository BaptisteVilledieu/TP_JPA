/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString(callSuper = true)
@Entity 
public class Artiste extends Personne{
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String biographie;
    
    public Artiste(Integer id, String nom, String adresse, String biographie) {
        super(id, nom, adresse);
        this.biographie = biographie;
    }
    @OneToMany(mappedBy = "auteur")
    private List<Tableau> oeuvres = new LinkedList<>();

}
