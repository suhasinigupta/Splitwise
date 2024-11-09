package dev.suhasini.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserLoginResponsedto {
    private UUID id ;
    private String name ;
    private String email ;
    private List<UserFriendDto> friends ;
    private  List<Groupdto> groups ;
}
