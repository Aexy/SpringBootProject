package at.developer.springbootproject.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @GetMapping("/error")
    public String handleError(WebRequest webRequest, Model model) {
        Map<String, Object> errors = errorAttributes.getErrorAttributes(
                webRequest, ErrorAttributeOptions.defaults());

        int status = (int) errors.get("status");  // Extract HTTP status code

        model.addAttribute("status", status);
        model.addAttribute("errorMessage", (String) errors.getOrDefault("error", "Unknown error"));

        // Show a different page for 404 errors
        if (status == 404) {
            return "error-404";
        }
        return "error"; // Default error page
    }
}

