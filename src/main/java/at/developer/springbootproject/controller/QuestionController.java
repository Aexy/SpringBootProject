package at.developer.springbootproject.controller;

import at.developer.springbootproject.Question;
import at.developer.springbootproject.dao.QuestionDao;
import at.developer.springbootproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question") //http://localhost:8090/question/
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionDao questionDao;
    @GetMapping("/questions")
    public String getQuestions(Model model){
        model.addAttribute("questions",questionService.getAllQuestions());
        return "questions";
    }

    @GetMapping("/allQuestions") //http://localhost:8090/question/allQuestions
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}") //http://localhost:8090/question/category/java
    public List<Question> getQuestionByCategory(@PathVariable String category) {
        return questionDao.findByCategory(category.toLowerCase());
    }

    @PostMapping("/add") //http://localhost:8090/question/add (use postman)
    public String addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/deleteById/{id}") //http://localhost:8090/question/deleteById/27 (use postman)
    public String deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

}
