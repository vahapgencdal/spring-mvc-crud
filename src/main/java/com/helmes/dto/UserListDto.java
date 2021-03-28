package com.helmes.dto;

import com.helmes.model.User;
import lombok.Data;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
@Data
public class UserListDto {

    private Long id;
    private String name;
    private boolean agreeToTerm;

    public static UserListDto toDto(User user){
       UserListDto userListDto = new UserListDto();
        userListDto.setAgreeToTerm(user.getAgreeTerms());
        userListDto.setId(user.getId());
        userListDto.setName(user.getName());
        return userListDto;
    }
}
