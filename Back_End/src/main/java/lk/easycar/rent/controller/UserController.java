package lk.easycar.rent.controller;

import lk.easycar.rent.entity.Car;
import lk.easycar.rent.entity.User;
import lk.easycar.rent.service.RentalService;
import lk.easycar.rent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(params = {"userName"})
    public User findByUserName(String userName) {
        System.out.println(userName);
        return userService.findByUserName(userName);
    }
}
