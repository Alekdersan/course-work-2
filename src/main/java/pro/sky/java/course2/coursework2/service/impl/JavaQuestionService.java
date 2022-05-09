package pro.sky.java.course2.coursework2.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.repository.impl.QuestionRepository;
import pro.sky.java.course2.coursework2.service.QuestionService;

import java.util.*;

@Service("javaService")
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository javaQuestionRepository;
    private Random random = new Random();

    public JavaQuestionService(@Qualifier("javaRepository") QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public boolean add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return javaQuestionRepository.add(newQuestion);
    }

    @Override
    public boolean add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public boolean remove(String question, String answer) {
        return javaQuestionRepository.remove(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(javaQuestionRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = List.copyOf(javaQuestionRepository.getAll());
        return questions.get(random.nextInt(questions.size() + 1));
    }

    @Override
    public int getSize() {
        return javaQuestionRepository.getAll().size();
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
