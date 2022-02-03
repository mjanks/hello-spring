package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, String language) {
        return createMessage(name, language);
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action = '/hello' method = 'post' >" + // submit a request to /hello
                            "<input type = 'text' name = 'name' >" +
                            "<select name = 'language' id = 'select-lang' >" +
                                "<option value = ''> Select a language </option>" +
                                "<option value = 'english'> English </option>" +
                                "<option value = 'spanish'> Spanish </option>" +
                                "<option value = 'french'> French </option>" +
                                "<option value = 'german'> German </option>" +
                                "<option value = 'japanese'> Japanese </option>" +
                            "</select>" +
                            "<input type = 'submit' value = 'Greet Me!' >" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        switch (language) {
            case "english":
                return "<html>" +
                        "<body>" +
                        "<h1 style='color: blue;'> Hello " + name +
                        "</h1>" +
                        "</body>" +
                        "</html>";
            case "spanish":
                return "<html>" +
                        "<body>" +
                        "<h1 style='color: red;'> Hola " + name +
                        "</h1>" +
                        "</body>" +
                        "</html>";
            case "french":
                return "<html>" +
                        "<body>" +
                        "<h1 style='color: green;'> Bonjour " + name +
                        "</h1>" +
                        "</body>" +
                        "</html>";
            case "german":
                return "<html>" +
                        "<body>" +
                        "<h1 style='color: orange;'> Hallo " + name +
                        "</h1>" +
                        "</body>" +
                        "</html>";
            case "japanese":
                return "<html>" +
                        "<body>" +
                        "<h1 style='color: purple;'> Konnichiwa " + name +
                        "</h1>" +
                        "</body>" +
                        "</html>";
            default:
                throw new IllegalStateException("Unexpected value: " + language);
        }
    }

}