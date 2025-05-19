package comspringboot.encuesta.encuesta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import comspringboot.encuesta.encuesta.models.StyleMusical;
import comspringboot.encuesta.encuesta.models.Survey;
import comspringboot.encuesta.encuesta.repositories.SurveyRepositorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SurveyServiceTest {

    @Mock
    private SurveyRepositorie surveyRepositorie;

    @InjectMocks
    private SurveyService surveyService;

    private StyleMusical rock;
    private Survey s1;
    private Survey s2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        rock = new StyleMusical();
        rock.setId(1L);
        rock.setName("Rock");

        s1 = new Survey(1L, "juan@test.com", rock);
        s2 = new Survey(2L, "ana@test.com", rock);
    }

    @Test
    public void testListarTodos() {
        when(surveyRepositorie.findAll()).thenReturn(Arrays.asList(s1, s2));

        List<Survey> result = surveyService.ListarTodos();

        assertEquals(2, result.size());
        assertEquals("juan@test.com", result.get(0).getEmail());
        verify(surveyRepositorie, times(1)).findAll();
    }

    @Test
    public void testSaveData() {
        when(surveyRepositorie.save(s1)).thenReturn(s1);

        Survey result = surveyService.saveData(s1);

        assertEquals("juan@test.com", result.getEmail());
        assertEquals("Rock", result.getStyleMusical().getName());
        verify(surveyRepositorie, times(1)).save(s1);
    }

    @Test
    public void testFindByEmail() {
        when(surveyRepositorie.findByEmail("juan@test.com")).thenReturn(Optional.of(s1));

        Optional<Survey> result = surveyService.findByEmail("juan@test.com");

        assertEquals(true, result.isPresent());
        assertEquals("juan@test.com", result.get().getEmail());
        verify(surveyRepositorie, times(1)).findByEmail("juan@test.com");
    }
}