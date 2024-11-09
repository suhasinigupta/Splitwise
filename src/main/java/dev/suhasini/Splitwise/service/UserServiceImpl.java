package dev.suhasini.Splitwise.service;

import dev.suhasini.Splitwise.dto.UserLogindto;
import dev.suhasini.Splitwise.dto.UserSignUpdto;
import dev.suhasini.Splitwise.exception.InvalidCredentials;
import dev.suhasini.Splitwise.model.User;
import dev.suhasini.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository ;
    public User signup(UserSignUpdto userSignUpdto){
        User savedUser =userRepository.findUserByEmail(userSignUpdto.getEmail()) ;
        if(savedUser != null){
            throw new InvalidCredentials("User Already exists") ;
        }
        User user=new User() ;
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder() ;
        user.setPassword(encoder.encode(userSignUpdto.getPassword()));
        user.setName(userSignUpdto.getName());
        user.setEmail(userSignUpdto.getEmail());
        userRepository.save(user) ;
        return userRepository.findUserByEmail(userSignUpdto.getEmail());
    }
    public User login(UserLogindto userLogindto) {

        User user=userRepository.findUserByEmail(userLogindto.getEmail()) ;
        BCryptPasswordEncoder decoder=new BCryptPasswordEncoder() ;
        if(user == null){
            throw new InvalidCredentials("User doesn't exist") ;
        }
        if(decoder.matches(userLogindto.getPassword(), user.getPassword())){
            return user ;
        }
        else throw new InvalidCredentials("Password doesn't match") ;
    }
}
