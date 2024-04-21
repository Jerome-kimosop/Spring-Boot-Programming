package org.webcalculator.calproject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalController {

    @PostMapping("/add")
    public double add(@RequestParam double operand1, @RequestParam double operand2) {
        return operand1 + operand2;
    }

    @PostMapping("/subtract")
    public double subtract(@RequestParam double operand1, @RequestParam double operand2) {
        return operand1 - operand2;
    }

    @PostMapping("/multiply")
    public double multiply(@RequestParam double operand1, @RequestParam double operand2) {
        return operand1 * operand2;
    }

    @PostMapping("/divide")
    public double divide(@RequestParam double operand1, @RequestParam double operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return operand1 / operand2;
    }

    @PostMapping("/")
    public String showCalculator() {
        return "calculator";
    }

    /**@GetMapping("/")
    public String showCalculator(Model model) {
        // Add attributes to the model
        model.addAttribute("operand1", ""); // Add a default value if needed
        model.addAttribute("operand2", "");
        return "calculator";
    }
     */
    @PostMapping("/calculate")
    public String calculate(@RequestParam int operand1, @RequestParam int operand2, @RequestParam String operation, Model model) {
        int result = 0;
        if ("add".equals(operation)) {
            result = operand1 + operand2;
        } else if ("subtract".equals(operation)) {
            result = operand1 - operand2;
        } else if ("multiply".equals(operation)) {
            result = operand1 * operand2;
        } else if ("divide".equals(operation)) {
            result = operand1 / operand2;
        }
        model.addAttribute("result", result);
        return "calculator";
    }

}

