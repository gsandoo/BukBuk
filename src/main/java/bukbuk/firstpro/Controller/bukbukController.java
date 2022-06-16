package bukbuk.firstpro.Controller;

import bukbuk.firstpro.model.BukReviewDTO;
import bukbuk.firstpro.model.BukServiceDTO;
import bukbuk.firstpro.repository.ServiceRepository;
import bukbuk.firstpro.service.BukServiceImpl;
import bukbuk.firstpro.service.BukServiceService;
import bukbuk.firstpro.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    ReviewServiceImpl reviewService;

    //고객센터 문의글 전체출력
    @RequestMapping("/service")
    public Map<String, Object> list(HttpServletRequest request){
        List<BukServiceDTO> list = this.bukService.getServiceList();

        Map<String, Object> map = new HashMap<>();

        map.put("service", list);

        return map;
    }

    @RequestMapping("/book")
    public Map<String, Object> reviewList(@RequestParam("book_title") String book_title, HttpServletRequest request){
        List<BukReviewDTO> list = this.reviewService.getReviewList(book_title);

        Map<String, Object> map = new HashMap<>();

        map.put("review", list);

        return map;
    }



}
