package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @Controller marks this class as a Spring MVC Controller.
// It handles web requests and returns the name of a view (JSP page).

public class HelloController {

    @GetMapping
    // Handles an HTTP GET request.
    // Used here to display the home page.

    public String showHomePage(Model model) {

        // Model is used to send data from the Controller to the JSP view.
        model.addAttribute("message", "Enter your name");

        // Returns the logical view name.
        // ViewResolver will resolve "home" to:
        // WEB-INF/views/home.jsp
        return "home";
    }


    @PostMapping
    // Handles an HTTP POST request.
    // Used here when the user submits their name.

    public String greetUser(
            @RequestParam String name,
            Model model) {

        // @RequestParam gets the value of a request parameter.
        // Here, it gets the "name" submitted from the form.

        model.addAttribute("message", "Hello" + name);

        // Sends the message to the JSP through the Model.
        // The JSP can access it using the appropriate JSP expression.

        // Returns the view name that should be displayed.
        return "Home";
    }
}