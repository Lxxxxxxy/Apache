package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lxxxxxxy
 * @time 2019/4/2 10:36
 */
@Controller
public class MappingController {
    @RequestMapping("/{path}")
    public String ftlMapping(@PathVariable String path){
        return path;
    }

    @RequestMapping("/")
    public String indexMapping(){
        return "index";
    }

    @RequestMapping("/user/{path}")
    public String userMapping(@PathVariable String path){
        return "/user/"+path;
    }
}
