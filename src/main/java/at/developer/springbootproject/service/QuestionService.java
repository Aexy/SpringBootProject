package at.developer.springbootproject.service;

import at.developer.springbootproject.Question;
import at.developer.springbootproject.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return (questionDao.existsById(question.getId())) ? "Question added" : "Question could not be added";
    }

    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return (questionDao.existsById(id)) ? "Question could not be deleted " : "Question is deleted";
    }
}
