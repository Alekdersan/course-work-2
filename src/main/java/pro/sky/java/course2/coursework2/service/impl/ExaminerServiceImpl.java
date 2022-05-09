package pro.sky.java.course2.coursework2.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.exception.InvalidExamGenerateException;
import pro.sky.java.course2.coursework2.service.ExaminerService;
import pro.sky.java.course2.coursework2.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaService;
    private final QuestionService mathService;

    private Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("javaService") QuestionService javaService,
                               @Qualifier("mathService") QuestionService mathService) {
        this.javaService = javaService;
        this.mathService = mathService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        List<QuestionService> services = List.of(javaService, mathService);
        int size = services.stream().mapToInt(QuestionService::getSize).sum();
        if (amount > 0 && size < amount) {
            throw new InvalidExamGenerateException(amount, size);
        }

        Random random = new Random();
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(services.get(random.nextInt(services.size() +  1)).getRandomQuestion());
        }
        return questions;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
