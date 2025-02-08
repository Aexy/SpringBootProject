package at.developer.springbootproject.controller;

import at.developer.springbootproject.entity.Coffee;
import at.developer.springbootproject.service.CoffeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@RequestMapping("coffee") //http://localhost:8090/coffee/
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/")
    public String getAllCoffees(Model model) {
        model.addAttribute("coffees", coffeeService.getAllCoffees());
        return "coffees";
    }

    @GetMapping("/id/{id}") //http://localhost:8090/coffee/id/{id}
    public String getCoffeeById(@PathVariable Long id, Model model) {
        Optional<Coffee> coffeeOptional = coffeeService.getCoffeeById(id);

        if (coffeeOptional.isEmpty()) {
            return "redirect:/coffees";
        }

        model.addAttribute("coffees", coffeeOptional.get());
        return "coffees";
    }
}
