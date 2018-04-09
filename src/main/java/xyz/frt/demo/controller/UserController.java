package xyz.frt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.frt.demo.common.JsonResult;
import xyz.frt.demo.model.User;
import xyz.frt.demo.service.UserService;

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public JsonResult selectAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/login")
    public JsonResult login(User user) {
        return userService.login(user);
    }

}
