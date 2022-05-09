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
@RequestMapping("/math")
public class MathQuestionController {

    private QuestionService mathQuestionService;

    public MathQuestionController(@Qualifier("mathService") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public void add(@RequestParam String question, @RequestParam String answer) {
        mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public void remove(@RequestParam String question, @RequestParam String answer) {
        mathQuestionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }
}
