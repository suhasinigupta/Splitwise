package dev.suhasini.Splitwise.controller;

import dev.suhasini.Splitwise.dto.UserLogindto;
import dev.suhasini.Splitwise.dto.UserSignUpdto;
import dev.suhasini.Splitwise.mapper.EntitytoDTO;
import dev.suhasini.Splitwise.model.User;
import dev.suhasini.Splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService ;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserSignUpdto userSignUpdto ){
        User user= userService.signup(userSignUpdto);

        return ResponseEntity.ok(EntitytoDTO.convertDTO(user)) ;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLogindto userLogindto){
        User user= userService.login(userLogindto) ;
        return ResponseEntity.ok(EntitytoDTO.convertDTO(user)) ;

    }

}
