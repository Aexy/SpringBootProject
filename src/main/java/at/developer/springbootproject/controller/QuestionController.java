package at.developer.springbootproject.controller;

import at.developer.springbootproject.Question;
import at.developer.springbootproject.dao.QuestionDao;
import at.developer.springbootproject.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question") //http://localhost:8090/question/
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionDao questionDao;

    public QuestionController(QuestionService questionService, QuestionDao questionDao) {
        this.questionService = questionService;
        this.questionDao = questionDao;
    }

    @GetMapping("/") //http://localhost:8090/question/allQuestions
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}") //http://localhost:8090/question/category/java
    public List<Question> getQuestionByCategory(@PathVariable String category) {
        return questionDao.findByCategory(category.toLowerCase());
    }

    @PostMapping("/add") //http://localhost:8090/question/add (use postman)
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/deleteById/{id}") //http://localhost:8090/question/deleteById/27 (use postman)
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

}
