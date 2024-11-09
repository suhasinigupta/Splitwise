package dev.suhasini.Splitwise.mapper;

import dev.suhasini.Splitwise.dto.Groupdto;
import dev.suhasini.Splitwise.dto.UserFriendDto;
import dev.suhasini.Splitwise.dto.UserLoginResponsedto;
import dev.suhasini.Splitwise.model.Group;
import dev.suhasini.Splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class EntitytoDTO {

    public static UserLoginResponsedto convertDTO(User user){
        UserLoginResponsedto responsedto=new UserLoginResponsedto() ;
        responsedto.setId(user.getId()) ;
        responsedto.setName(user.getName()) ;
        responsedto.setEmail(user.getEmail());
        if(user.getUserFriends()!=null){
            List<UserFriendDto> req=new ArrayList<>() ;
            for(User usr:user.getUserFriends()){
                req.add(toFriend(usr)) ;
            }
            responsedto.setFriends(req);
        }
        if(user.getGroups()!=null){
          List<Groupdto> grps=new ArrayList<>() ;
          for(Group grp:user.getGroups()){
              grps.add(togroup(grp)) ;
          }
          responsedto.setGroups(grps);
        }
        return responsedto ;
    }

    public static UserFriendDto toFriend(User user){
        UserFriendDto friend=new UserFriendDto() ;
        friend.setId(user.getId());
        friend.setName(user.getName());
        return friend ;
    }

    public static Groupdto togroup(Group group){
        Groupdto groupdto=new Groupdto() ;
        groupdto.setGrpId(group.getId());
        groupdto.setName(group.getName());
        return groupdto ;
    }
}
