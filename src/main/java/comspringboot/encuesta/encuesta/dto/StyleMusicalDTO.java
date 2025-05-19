package comspringboot.encuesta.encuesta.dto;

import comspringboot.encuesta.encuesta.models.StyleMusical;

public class StyleMusicalDTO {
    
    private Long id;
    private String name;

    public StyleMusicalDTO() {
    }

    public StyleMusicalDTO(StyleMusical p_style_musical) {
        this.id = p_style_musical.getId();
        this.name = p_style_musical.getName();
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

}
