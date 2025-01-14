package at.developer.springbootproject.service;

import at.developer.springbootproject.Question;
import at.developer.springbootproject.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public ResponseEntity<String> addQuestion(Question question) {
        HttpStatus status;
        if(questionDao.existsById(question.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>("ID already exists",status);
        }
        if(!List.of(question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4()).contains(question.getRight_answer())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>("Correct option is not one of the answers",status);
        }
        questionDao.save(question);
        status = HttpStatus.CREATED;
        return new ResponseEntity<>(question.getQuestion_title(), status);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        HttpStatus status;
        if(!questionDao.existsById(id)){
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>("ID not found:" + id, status);
        }
        questionDao.deleteById(id);
        status = HttpStatus.ACCEPTED;
        return new ResponseEntity<>("Question with the ID: " + id + " has been deleted", status);
    }
}
