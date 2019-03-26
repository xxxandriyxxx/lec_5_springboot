package owu2018.lec_5_springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import owu2018.lec_5_springboot.dao.UserDAO;
import owu2018.lec_5_springboot.models.Email;
import owu2018.lec_5_springboot.models.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "index";
    }

    @Autowired
    private UserDAO userDAO;

    @PostMapping("/saveUser")
    public String saveU(
//            @RequestParam("name") String username)
            @RequestParam String name,
//            User user,
            Model model
            , @RequestParam String email
    ) {
        User user = new User();
        user.setName(name);

        Email mail = new Email();
        mail.setEmail(email);
        mail.setUser(user);

        List<Email> emailList = new ArrayList<>();
        emailList.add(mail);
        user.setEmails(emailList);

        userDAO.save(user);
        model.addAttribute("allUsers", userDAO.findAll());

        System.out.println(user);
        return "userSaveDone";
    }

    @GetMapping("/user-{xxx}")
    public String singleUser(@PathVariable("xxx") int id, Model model) {
        model.addAttribute("currentUser", userDAO.findById(id).get());
        return "singleUser";
    }


}
