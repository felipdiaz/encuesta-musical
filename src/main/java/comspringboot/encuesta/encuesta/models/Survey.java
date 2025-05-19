package comspringboot.encuesta.encuesta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Survey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @ManyToOne
    private StyleMusical styleMusical;

    public Survey() {
    }

    public Survey(Long id, String email, StyleMusical styleMusical) {
        this.id = id;
        this.email = email;
        this.styleMusical = styleMusical;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StyleMusical getStyleMusical() {
        return styleMusical;
    }

    public void setStyleMusical(StyleMusical styleMusical) {
        this.styleMusical = styleMusical;
    }


    
    
}
