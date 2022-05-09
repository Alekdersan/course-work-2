package pro.sky.java.course2.coursework2.repository.impl;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.coursework2.data.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("mathRepository")
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public MathQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("5 + 5","10"));
        add(new Question("12 - 7", "5"));
        add(new Question("6 * 4", "24"));
        add(new Question("81 / 9", "9"));
    }

    @Override
    public boolean add(Question question) {
        return questions.add(question);
    }

    @Override
    public boolean remove(Question question) {
        return questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}
