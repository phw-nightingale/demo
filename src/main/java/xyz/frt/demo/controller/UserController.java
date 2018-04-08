package xyz.frt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.frt.demo.common.JsonResult;
import xyz.frt.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public JsonResult selectAllUsers() {
        return userService.selectAll();
    }

}
