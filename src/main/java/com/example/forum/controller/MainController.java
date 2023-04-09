package com.example.forum.controller;

import com.example.forum.model.User;
import com.example.forum.service.ForumService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class MainController {
    private ForumService forumService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> handleLogin(HttpSession session,
                                         @RequestParam("username") String username,
                                         @RequestParam("password") String password){
        User user = forumService.checkUser(username, password);
        if(user != null){
            session.setAttribute("user", user);
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/test")
    public String test(HttpSession session){
        String redirect = checkUserSession(session);
        if (redirect != null) return redirect;
        return "pro";
    }

    private static String checkUserSession(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "redirect:/login";
        }
        return null;
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
