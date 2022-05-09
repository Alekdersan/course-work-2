package pro.sky.java.course2.coursework2.repository.impl;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.coursework2.data.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("javaRepository")
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("Сколько модификаторов доступа?", "4"));
        add(new Question("Что такое сигнатура метода?", "Набор из названия метода и аргументов."));
        add(new Question("Какой принцип ООП применяется при перегрузке методов?", "Полиморфизм."));
        add(new Question("Какой размер в ячейке области памяти будет занят переменной ссылочного типа?", "Размер ссылки в JVM зависит от ее разрядности: в 32 разрядной системе - 4 байта, в 64 разрадной системе - 8 байт."));
        add(new Question("Можно ли считать переменную с ключевым словом final константой? Да/ Нет.", "Нет."));
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
