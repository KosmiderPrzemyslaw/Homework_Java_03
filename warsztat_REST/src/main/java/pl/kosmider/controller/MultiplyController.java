package pl.kosmider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplyController {
    @GetMapping("/multiply")
    public String multiply(@RequestParam(defaultValue = "10") int size, Model model) {

        model.addAttribute("size", size);
        return "multiply";
    }

    @GetMapping("/paramMultiply/{rows}/{columns}")
    public String paramMultiply (@PathVariable int rows, @PathVariable int columns, Model model) {
        model.addAttribute("rows", rows);
        model.addAttribute("columns", columns);

        return "paramMultiply";
    }
}
