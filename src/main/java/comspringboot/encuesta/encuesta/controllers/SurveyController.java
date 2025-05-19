package comspringboot.encuesta.encuesta.controllers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comspringboot.encuesta.encuesta.dto.StyleMusicalDTO;
import comspringboot.encuesta.encuesta.dto.SurveyDTO;
import comspringboot.encuesta.encuesta.models.StyleMusical;
import comspringboot.encuesta.encuesta.models.Survey;
import comspringboot.encuesta.encuesta.services.SurveyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/survey")
public class SurveyController {

    @Autowired
    private SurveyService serv_survey;

    @GetMapping
    public ResponseEntity<List<SurveyDTO>> listAll() {
    List<Survey> styleMusicalList = serv_survey.ListarTodos();
    List<SurveyDTO> dtoList = styleMusicalList.stream()
                                      .map(SurveyDTO::new)
                                      .collect(Collectors.toList());
    return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }   

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Survey in_survey){
        boolean exists = serv_survey.findByEmail(in_survey.getEmail()).isPresent();

        if(exists) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Collections.singletonMap("error", "El email ya existe, no se puede crear la encuesta."));
        }

        Survey inserted = serv_survey.saveData(in_survey);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }
    
    
}
