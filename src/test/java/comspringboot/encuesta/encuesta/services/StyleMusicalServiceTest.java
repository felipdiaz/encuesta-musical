package comspringboot.encuesta.encuesta.services;

import comspringboot.encuesta.encuesta.models.StyleMusical;
import comspringboot.encuesta.encuesta.repositories.StyleMusicalRepositorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StyleMusicalServiceTest {

    @Mock
    private StyleMusicalRepositorie styleMusicalRepositorie;

    @InjectMocks
    private StyleMusicalService styleMusicalService;

    private StyleMusical rock;
    private StyleMusical jazz;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        rock = new StyleMusical();
        rock.setId(1L);
        rock.setName("Rock");

        jazz = new StyleMusical();
        jazz.setId(2L);
        jazz.setName("Jazz");
    }

    @Test
    public void testListStyleMusical() {
        when(styleMusicalRepositorie.findAll()).thenReturn(Arrays.asList(rock, jazz));

        List<StyleMusical> result = styleMusicalService.ListStyleMusical();

        assertEquals(2, result.size());
        assertEquals("Rock", result.get(0).getName());
        assertEquals("Jazz", result.get(1).getName());

        verify(styleMusicalRepositorie, times(1)).findAll();
    }
}