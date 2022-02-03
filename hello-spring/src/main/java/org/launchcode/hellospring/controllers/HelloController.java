package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // Responds to get requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Responds to post requests at /goodbye
    @PostMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Responds to get and post requests at /hellogoodbye
    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hellogoodbye() {
        return "Hello Goodbye, Spring!";
    }

    // Responds to get requests at /hello?coder=LaunchCoder
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String coder) {
        return "Hello, " + coder + "!";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
