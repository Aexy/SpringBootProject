package at.developer.springbootproject.service;

import at.developer.springbootproject.dao.CoffeeDao;
import at.developer.springbootproject.dao.OriginCountryDao;
import at.developer.springbootproject.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {

    private final CoffeeDao coffeeRepository;
    private final OriginCountryDao originCountryRepository;

    public CoffeeService(CoffeeDao coffeeRepository, OriginCountryDao originCountryRepository) {
        this.coffeeRepository = coffeeRepository;
        this.originCountryRepository = originCountryRepository;
    }

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Optional<Coffee> getCoffeeById(Long id) {
        return coffeeRepository.findById(id);
    }
}
