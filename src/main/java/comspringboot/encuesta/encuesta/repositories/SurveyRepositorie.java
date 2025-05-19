package comspringboot.encuesta.encuesta.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comspringboot.encuesta.encuesta.models.Survey;

@Repository
public interface SurveyRepositorie extends JpaRepository<Survey, Long>{
     Optional<Survey> findByEmail(String email);
}
