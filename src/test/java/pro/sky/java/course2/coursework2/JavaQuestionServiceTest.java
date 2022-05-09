package pro.sky.java.course2.coursework2;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.tags.form.SelectTag;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.repository.impl.QuestionRepository;
import pro.sky.java.course2.coursework2.service.impl.JavaQuestionService;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void add_test() {
        Question question = new Question("testQuestion", "testAnswer");
        when(repository.add(question)).thenReturn(true, false);

        assertTrue(out.add(question));
        assertFalse(out.add(question));
    }

    @Test
    public void remove_test() {
        String questionText = "testQuestion";
        String answerText = "testAnswer";
        Question question = new Question(questionText, answerText);
        when(repository.remove(question)).thenReturn(true, false);

        assertTrue(out.remove(questionText, answerText));
        assertFalse(out.remove(questionText, answerText));
    }

    @Test
    public void getAll_test() {
        Set<Question> questions = Set.of(
                new Question("testQuestion1", "testAnswer1"),
                new Question("testQuestion2", "testAnswer2")
        );
        when(repository.getAll()).thenReturn(questions);

        assertEquals(out.getAll().size(), questions.size());
        assertTrue(out.getAll().containsAll(questions));
    }

    @Test
    public void getRandomQuestion_test() {
        when(repository.getAll()).thenReturn(List.of(
                new Question("testQuestion", "testAnswer"),
                new Question("testQuestion1", "testAnswer1"),
                new Question("testQuestion2","testAnswer2"),
                new Question("testQuestion3", "testAnswer3")
        ));

        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(anyInt())).thenReturn(0, 3);
        out.setRandom(randomMock);

        assertEquals(new Question("testQuestion","testAnswer"), out.getRandomQuestion());
        assertEquals(new Question("testQuestion3","testAnswer3"), out.getRandomQuestion());
    }
}
