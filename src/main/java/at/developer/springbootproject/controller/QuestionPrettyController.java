package at.developer.springbootproject.controller;

import at.developer.springbootproject.dao.QuestionDao;
import at.developer.springbootproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("questions") //http://localhost:8090/question/
public class QuestionPrettyController{
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionDao questionDao;

    @GetMapping("/all")
    public String getQuestions(Model model){
        model.addAttribute("questions",questionService.getAllQuestions());
        return "questions";
    }

    @GetMapping("category/{category}")
    public String getQuestionsByCategory(@PathVariable String category, Model model){
        model.addAttribute("questions", questionDao.findByCategory(category));
        return "questions";
    }
}
