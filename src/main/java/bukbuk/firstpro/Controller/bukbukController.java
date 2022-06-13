package bukbuk.firstpro.Controller;

import bukbuk.firstpro.model.BukServiceDTO;
import bukbuk.firstpro.repository.ServiceRepository;
import bukbuk.firstpro.service.BukServiceImpl;
import bukbuk.firstpro.service.BukServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class bukbukController {

    @GetMapping("/home")
    public String test(){
        return "hello, world";
    }

    @GetMapping("/hello-mvc")
    public String helloMVC(){

        return "hello-template";
    }
    @Autowired
    BukServiceImpl bukService;

    @RequestMapping("/service")
    public Map<String, Object> list(HttpServletRequest request){
        List<BukServiceDTO> list = this.bukService.getServiceList();

        Map<String, Object> map = new HashMap<>();

        map.put("service", list);

        return map;
    }


}
