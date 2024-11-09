package dev.suhasini.Splitwise.service;

import dev.suhasini.Splitwise.dto.UserLogindto;
import dev.suhasini.Splitwise.dto.UserSignUpdto;
import dev.suhasini.Splitwise.model.User;
import dev.suhasini.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User signup(UserSignUpdto userSignUpdto) ;
    User login(UserLogindto userLogindto) ;

}
