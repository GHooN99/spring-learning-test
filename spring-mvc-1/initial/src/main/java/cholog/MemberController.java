package cholog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MemberController {

    @GetMapping("/hello")
    public String world(@RequestParam(value = "name", required = false) Optional<String> name, Model model) {
        // TODO: /hello 요청 시 resources/templates/static.html 페이지가 응답할 수 있도록 설정하세요.
        if (name.isEmpty()) {
            return "static";
        }

        // TODO: 쿼리 파라미터로 name 요청이 들어왔을 때 해당 값을 hello.html에서 사용할 수 있도록 하세요.
        model.addAttribute("name", name.orElseGet(() -> "world"));
        return "hello";

    }

    @ResponseBody
    @GetMapping("/json")
    public Person json() {
        // TODO: /json 요청 시 {"name": "brown", "age": 20} 데이터를 응답할 수 있도록 설정하세요.
        return new Person("brown", 20);
    }
}
