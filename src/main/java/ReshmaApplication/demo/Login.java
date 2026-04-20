package ReshmaApplication.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String pass) {

        if (user.equals("admin") && pass.equals("1234")) {
            return "Login Success";
        } else {
            return "Login Failed";
        }
    }
}