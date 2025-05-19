package comspringboot.encuesta.encuesta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comspringboot.encuesta.encuesta.models.StyleMusical;
import comspringboot.encuesta.encuesta.repositories.StyleMusicalRepositorie;

@Service
public class StyleMusicalService {
    @Autowired
    private StyleMusicalRepositorie repo_style_musical;

    public List<StyleMusical> ListStyleMusical(){
        return repo_style_musical.findAll();
    }
}
