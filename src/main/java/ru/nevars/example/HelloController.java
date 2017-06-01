package ru.nevars.example;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/v1", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadMainPage() {
        return "index";
    }
}
