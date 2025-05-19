package comspringboot.encuesta.encuesta.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comspringboot.encuesta.encuesta.dto.StyleMusicalDTO;
import comspringboot.encuesta.encuesta.models.StyleMusical;
import comspringboot.encuesta.encuesta.services.StyleMusicalService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/style-musical")
public class StyleMusicalController {

    @Autowired
    private StyleMusicalService serv_style_musical;

    @GetMapping
    public ResponseEntity<List<StyleMusicalDTO>> listAll() {
    List<StyleMusical> styleMusicalList = serv_style_musical.ListStyleMusical();
    List<StyleMusicalDTO> dtoList = styleMusicalList.stream()
                                      .map(StyleMusicalDTO::new)
                                      .collect(Collectors.toList());
    return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }   
    

}
