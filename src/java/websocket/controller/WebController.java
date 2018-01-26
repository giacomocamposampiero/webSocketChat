package websocket.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.net.jsse.openssl.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import websocket.model.User;
import websocket.service.UserService;

@Controller
@RequestMapping("/")
@ComponentScan("websocket.service")
public class WebController {

    @Autowired
    UserService service;

    public WebController() {
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(ModelMap model) {
        User u= new User();
        model.addAttribute("user",u);
        return "register";
    }

    @RequestMapping(value = {"/check"}, params = {"user", "pass"}, method = RequestMethod.POST)
    public String check(ModelMap model, @RequestParam("user") String usern, @RequestParam("pass") String pass) {
        User user = service.findUserById(usern);
        if (user == null) {
            model.addAttribute("ErrMsg", "Errore : nome utente non esistente");
            return "login";
        } else if (user.getPasswd().equals(pass)) {
            model.addAttribute("username", usern);
            return "chat";
        } else{
            model.addAttribute("ErrMsg", "Errore : password sbagliata");
            return "login";
        }

    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String add(ModelMap model, @ModelAttribute("user") User u) {
        User user = service.findUserById(u.getUsername());
        if (user == null) {
            service.saveUser(u);
            model.addAttribute("username", u.getUsername());
            return "chat";
        }
        model.addAttribute("ErrMsg", "Errore : nome utente gia` in uso");
        model.addAttribute("user",u);
        return "register";

    }
    

}