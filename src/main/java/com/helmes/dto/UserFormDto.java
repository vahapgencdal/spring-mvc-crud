package com.helmes.dto;
import com.helmes.model.User;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
@Data
public class UserFormDto {


    private long id;

    @Size(min = 3,max = 255, message = "Size of User Name must be between 3 and 255")
    private String name;

    @AssertTrue(message = "Agree To Term have to be selected")
    private boolean agreeToTerm;

    @NotEmpty(message = "User Sectors can not be empty")
    private List<Long> sectorIdList;

    private List<SectorFormDto> sectors;

    public static UserFormDto toDto(User user){
        UserFormDto uf=new UserFormDto();
        uf.setId(user.getId());
        uf.setAgreeToTerm(user.getAgreeTerms());
        uf.setName(user.getName());
        return uf;
    }

    public static User toEntity(UserFormDto dto) {
        User user = new User();
        user.setName(dto.getName());
        return user;
    }
}
