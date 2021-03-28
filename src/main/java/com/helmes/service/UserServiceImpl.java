package com.helmes.service;


import com.helmes.utils.Util;
import com.helmes.dto.SectorFormDto;
import com.helmes.dto.UserFormDto;
import com.helmes.dto.UserListDto;
import com.helmes.model.Sector;
import com.helmes.model.User;
import com.helmes.repository.SectorRepository;
import com.helmes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<UserListDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserListDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public User save(UserFormDto userFormDto){

        User user = findById(userFormDto.getId()).orElseGet(User::new);

        user.setName(userFormDto.getName());
        user.setAgreeTerms(userFormDto.isAgreeToTerm());

        Set<Sector> sectorList = new HashSet<>(sectorRepository.findByIdIn(userFormDto.getSectorIdList()));

        user.setSectors(sectorList);

        return userRepository.save(user);
    }

    @Override
    public UserFormDto getUserDto(Long id) {


        User user = findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        final List<Long> userSectors = user.getSectors().stream().map(Sector::getId).collect(Collectors.toList());

        List<Sector> allSectors = sectorRepository.findByParentIsNull();

        final List<SectorFormDto> sortedList= new ArrayList<>();

        Util.mapSectorToForm(allSectors, sortedList);

        UserFormDto userFormDto = UserFormDto.toDto(user);
        userFormDto.setSectors(sortedList);
        userFormDto.setSectorIdList(userSectors);

        return userFormDto;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
