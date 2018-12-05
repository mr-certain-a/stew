package orange;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "HELLO, IN STEW IN HODGEPODGE");
        return "hello";
    }
    
    @GetMapping("/verDiff")
    @ResponseBody
    public ModuleVersion versionDiff(@RequestParam(name="name", required=false) String name) {
        return new ModuleVersion(name, 0);
    }    
}
