package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @NonNull
    private String nom;
    
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "organisateur")
    private List<Exposition> evenements = new LinkedList<>();
    
    public float CAannuel(int annee){
        float calculCAAnnuel =0;
        for(Exposition e : evenements){
            if(e.getDebut().getYear()==annee && (e.getDebut().getDayOfYear()+e.getDuree())<365){
            calculCAAnnuel += e.CA();
            }
        }
        return calculCAAnnuel;
    }
}
