package at.developer.springbootproject.controller;

import at.developer.springbootproject.Question;
import at.developer.springbootproject.dao.QuestionDao;
import at.developer.springbootproject.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("questions") //http://localhost:8090/questions/
public class QuestionPrettyController{
    private final QuestionService questionService;
    private final QuestionDao questionDao;

    private String imagePath = null;

    public QuestionPrettyController(QuestionService questionService, QuestionDao questionDao) {
        this.questionService = questionService;
        this.questionDao = questionDao;
    }

    @GetMapping("/all")//http://localhost:8090/questions/all
    public String getQuestions(Model model){
        model.addAttribute("questions",questionService.getAllQuestions());
        adjustImage(model,"");
        return "questions";
    }

    @GetMapping("category/{category}")//http://localhost:8090/questions/category/
    public String getQuestionsByCategory(@PathVariable String category, Model model){
        model.addAttribute("questions", questionDao.findByCategory(category));
        model.addAttribute("category", category);
        adjustImage(model,category);
        return "questions";
    }

    @GetMapping("/id/{id}") //http://localhost:8090/questions/id/
    public String getQuestionById(@PathVariable Integer id, Model model){
        if(questionDao.findById(id).isEmpty()){
            return "questions";
        }
        model.addAttribute("questions", questionDao.findById(id).get());
        model.addAttribute("category", questionDao.findById(id).get().getCategory());
        adjustImage(model,questionDao.findById(id).get().getCategory());
        return "questions";
    }

    //TODO: Not working right now
    @GetMapping("/difficulty/{difficulty}")
    public String getQuestionByDifficulty(@PathVariable String difficulty,Model model){
        adjustImage(model,"");
        if(!difficulty.equalsIgnoreCase("easy") && !difficulty.equalsIgnoreCase("hard") && !difficulty.equalsIgnoreCase("medium")){
            model.addAttribute("questions", "");
            return "questions";
        }
        model.addAttribute("questions", questionDao.findByDifficulty(difficulty.toLowerCase()));
        return "questions";
    }


    /*
        * Auxiliary Methods
     */

    /**
     * Used to add or remove the image if accordingly
     * @param model the model to add the attribute
     * @param category the category of the question
     */
    private void adjustImage(Model model, String category){
        imagePath = null;
        if(category.equalsIgnoreCase("java")){
            imagePath = "/images/Java-Logo.png";
        }
        if(category.equalsIgnoreCase("python")){
            imagePath = "/images/Python-Logo.png";
        }
        model.addAttribute("image", imagePath);
    }
}
