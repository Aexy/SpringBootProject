package at.developer.springbootproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question") //http://localhost:8090/question/
public class QuestionController {
    @GetMapping("allQuestions") //http://localhost:8090/question/allQuestions
    public String getAllQuestions() {
        return "These are all the questions";
    }

}
