package comspringboot.encuesta.encuesta.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class StyleMusical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    
    @OneToMany(mappedBy = "styleMusical")
    List<Survey> surveys;
    public StyleMusical() {
    }
    public StyleMusical(Long id, String name, List<Survey> surveys) {
        this.id = id;
        this.name = name;
        this.surveys = surveys;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Survey> getSurveys() {
        return surveys;
    }
    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    
    
    


    
}
