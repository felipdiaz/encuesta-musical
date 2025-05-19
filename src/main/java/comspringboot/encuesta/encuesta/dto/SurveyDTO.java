package comspringboot.encuesta.encuesta.dto;

import comspringboot.encuesta.encuesta.models.Survey;

public class SurveyDTO {

    private Long id;
    private String email;
    private StyleMusicalDTO styleMusical;

    
    public SurveyDTO() {
    }


    public SurveyDTO(Survey p_survey) {
        this.id = p_survey.getId();
        this.email = p_survey.getEmail();
        styleMusical = new StyleMusicalDTO(p_survey.getStyleMusical());
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


    public StyleMusicalDTO getStyleMusical() {
        return styleMusical;
    }


    public void setStyleMusical(StyleMusicalDTO styleMusical) {
        this.styleMusical = styleMusical;
    }


    
}
