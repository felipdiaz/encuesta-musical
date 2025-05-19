package comspringboot.encuesta.encuesta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comspringboot.encuesta.encuesta.models.Survey;
import comspringboot.encuesta.encuesta.repositories.SurveyRepositorie;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepositorie repo_survey;

    public List<Survey> ListarTodos(){
        return repo_survey.findAll();
    }

    public Survey saveData(Survey survey){
        return repo_survey.save(survey);
    }

    public Optional<Survey> findByEmail(String email){
        return repo_survey.findByEmail(email);
    }

}
