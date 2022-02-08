package security.src.main.java.com.ankit;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class TopicCntrl {
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> getalltopic() {
    return Arrays.asList(
        new Topic("apring", "spring framework", "spring framework describtion"),
        new Topic("java", "core", "describe")
            );
    }
} 