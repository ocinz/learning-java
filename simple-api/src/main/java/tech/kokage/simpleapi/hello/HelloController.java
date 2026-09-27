package tech.kokage.simpleapi.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello(){
        return "Hello Backend";
    }
    @GetMapping("/goodbye")
    public  String goodbye(){
        return "Goodbye!";
    }
    @GetMapping("/{name}")
    public String hi(@PathVariable String name){
        return "Hi, " + name;
    }
}
