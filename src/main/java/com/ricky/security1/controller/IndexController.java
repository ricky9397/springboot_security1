package com.ricky.security1.controller;

import com.ricky.security1.model.User;
import com.ricky.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;
    @GetMapping({"","/"})
    public String index(){
        // 머스테치 기본폴더 -> src/main/resources/
        // 뷰리졸버 설정 : templates (prefix), .mustache(suffix)
        return "index"; // scr/main/resources/templates/index.mustache
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public String manager(){
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    @ResponseBody
    public String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPw = user.getPassword();
        String encPw = encoder.encode(rawPw);
        user.setPassword(encPw);
        userRepository.save(user);
        return "redirect:/loginForm";
    }

    @Secured("ROLE_ADMIN") // 권한 어너테이션(특정메소드에 어너테이션)
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }

   @PreAuthorize("hasRole('ROLE_MANAGER')") // 권한 어너테이션 2(특정메소드에 어너테이션)
    @GetMapping("/data")
    public @ResponseBody String data(){
        return "데이터정보";
    }

}
