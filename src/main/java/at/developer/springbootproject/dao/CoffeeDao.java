package at.developer.springbootproject.dao;

import at.developer.springbootproject.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeDao extends JpaRepository<Coffee, Long> {

}
