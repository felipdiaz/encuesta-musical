package comspringboot.encuesta.encuesta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comspringboot.encuesta.encuesta.models.StyleMusical;

@Repository
public interface StyleMusicalRepositorie extends JpaRepository<StyleMusical, Long>{

}
