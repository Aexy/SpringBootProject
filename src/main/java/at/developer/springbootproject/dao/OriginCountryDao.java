package at.developer.springbootproject.dao;

import at.developer.springbootproject.entity.OriginCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OriginCountryDao extends JpaRepository<OriginCountry, Long> {

    List<OriginCountry> findByCoffeeId(Long coffeeId);
}