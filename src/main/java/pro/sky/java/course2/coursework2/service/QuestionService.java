package pro.sky.java.course2.coursework2.service;

import pro.sky.java.course2.coursework2.data.Question;

import java.util.Collection;
import java.util.Set;

public interface QuestionService {

    boolean add(String question, String answer);

    boolean add(Question question);

    boolean remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSize();
}
