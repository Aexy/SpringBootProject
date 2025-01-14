package at.developer.springbootproject.dao;

import at.developer.springbootproject.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    List<Question> findByDifficulty(String difficulty);
}
