package pro.sky.java.course2.coursework2.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.repository.impl.QuestionRepository;
import pro.sky.java.course2.coursework2.service.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service("mathService")
    public class MathQuestionService implements QuestionService {

    private final QuestionRepository mathQuestionRepository;
    private final Random random = new Random();

    public MathQuestionService(@Qualifier("mathRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public boolean add(String question, String answer) {
        return mathQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public boolean add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public boolean remove(String question, String answer) {
        return mathQuestionRepository.remove(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(mathQuestionRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = List.copyOf(mathQuestionRepository.getAll());
        return questions.get(random.nextInt(questions.size()));
    }

    @Override
    public int getSize() {
        return mathQuestionRepository.getAll().size();
    }
}
