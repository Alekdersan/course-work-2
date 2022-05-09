package pro.sky.java.course2.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidExamGenerateException extends IllegalArgumentException{
    public InvalidExamGenerateException(int amount, int currentSize) {
        super(String.format("Failed generate %d questions, the current size i% %d", amount, currentSize));
    }

}
