package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class TestController {
    @GetMapping
    public String hello(){
        return "Lets go this!";
    }
}
