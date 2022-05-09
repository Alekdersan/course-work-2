package pro.sky.java.course2.coursework2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService javaQuestionService;

    public JavaQuestionController(@Qualifier("javaService") QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public boolean add(@RequestParam("question") String question,
                      @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public boolean remove(@RequestParam("question") String question,
                       @RequestParam("answer") String answer) {
        return javaQuestionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }
}
