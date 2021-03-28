package com.helmes.service;


import com.helmes.dto.UserFormDto;
import com.helmes.dto.UserListDto;
import com.helmes.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
public interface UserService {

    List<UserListDto> findAll();

    User save(UserFormDto userFormDto);

    UserFormDto getUserDto(Long id);
    
    Optional<User> findById(Long id);

    void delete(User user);
}
