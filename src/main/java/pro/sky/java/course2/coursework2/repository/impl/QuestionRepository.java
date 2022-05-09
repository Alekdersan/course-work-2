package pro.sky.java.course2.coursework2.repository.impl;

import pro.sky.java.course2.coursework2.data.Question;

import java.util.Collection;

public interface QuestionRepository {

    boolean add(Question question);

    boolean remove(Question question);

    Collection<Question> getAll();
}
