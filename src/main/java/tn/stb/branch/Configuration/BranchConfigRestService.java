package tn.stb.branch.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope  // Enables dynamic refreshing of beans annotated with @Value
@RestController
public class BranchConfigRestService {

    @Value("${xParam}")  // Injects the value of the property "xParam" from configuration
    private int xParam;

    @Value("${yParam}")  // Injects the value of the property "yParam" from configuration
    private int yParam;

    @Value("${me}")  // Injects the value of the property "me" from configuration
    private String me;

    @GetMapping("/my-config")  // Defines an endpoint to access the configuration values
    public Map<String, Object> myConfig() {
        Map<String, Object> params = new HashMap<>();

        params.put("xParam", xParam);  // Adds "xParam" value to the response map
        params.put("yParam", yParam);  // Adds "yParam" value to the response map
        params.put("me", me);          // Adds "me" value to the response map

        params.put("threadName", Thread.currentThread().getName());  // Adds current thread name to the response map
        //Using threads helps your application handle multiple things at the same time, like talking to many users or doing different tasks,
        // so that it works smoothly and doesn't slow down when busy.
        return params;  // Returns the map containing configuration values
    }
}
