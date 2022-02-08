package security.src.main.java.com.ankit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
    @RequestMapping("/")
    public String Admin(){
        return "Hello this is rest for admin";
    }

    @RequestMapping("/hello")
    public String sayHi(){
        return "Hello this is rest for elec";
    }
}