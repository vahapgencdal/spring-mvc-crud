package com.helmes;


import com.helmes.dto.SectorFormDto;
import com.helmes.dto.UserFormDto;
import com.helmes.dto.UserListDto;
import com.helmes.model.Sector;
import com.helmes.model.User;
import com.helmes.repository.SectorRepository;
import com.helmes.repository.UserRepository;
import com.helmes.service.UserService;
import com.helmes.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */

@SpringBootTest
@Slf4j
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private SectorRepository sectorRepository;

    @Autowired
    private UserService userService;

    @Test
    void save_success_case() {

        UserFormDto expectedResult = new UserFormDto();
        expectedResult.setName("test");

        when(userRepository.save(any())).thenReturn(UserFormDto.toEntity(expectedResult));
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        when(sectorRepository.findByIdIn(any())).thenReturn(new ArrayList<>());

        User actualResult = userService.save(expectedResult);

        Assertions.assertEquals(expectedResult.getName(), actualResult.getName());

    }

    @Test
    void find_all_success_case() {

        User user = new User();
        user.setName("test");
        user.setId(1L);

        List<User> usersExpected = new ArrayList<>();
        usersExpected.add(user);

        when(userRepository.findAll()).thenReturn(usersExpected);

        List<UserListDto> actualResult = userService.findAll();

        Assertions.assertEquals(usersExpected.size(), actualResult.size());
        Assertions.assertEquals(usersExpected.get(0).getName(), actualResult.get(0).getName());

    }

    @Test
    void find_by_id_success_case() {

        User user = new User();
        user.setName("test");
        user.setId(1L);

        when(userRepository.findById(any())).thenReturn(Optional.of(user));

        Optional<User> actualResult = userService.findById(1L);

        Assertions.assertEquals(user.getName(), actualResult.get().getName());

    }

    @Test
    void get_user_dto_case() {

        UserFormDto expectedResult = new UserFormDto();
        expectedResult.setName("test");
        expectedResult.setAgreeToTerm(Boolean.TRUE);
        expectedResult.setSectorIdList(Arrays.asList(1L,2L));

        SectorFormDto sectorFormDto1 = new SectorFormDto();
        sectorFormDto1.setName("test1");
        sectorFormDto1.setId(1L);
        SectorFormDto sectorFormDto2= new SectorFormDto();
        sectorFormDto2.setName(Util.SPACE+"test2");
        sectorFormDto1.setId(2L);
        ArrayList<SectorFormDto> sectorFormDtos = new ArrayList<>();
        sectorFormDtos.add(sectorFormDto1);
        sectorFormDtos.add(sectorFormDto2);
        expectedResult.setSectors(sectorFormDtos);


        ArrayList<Sector> sectorList = new ArrayList<>();
        Sector sector1 = new Sector();
        sector1.setName("test1");
        sector1.setId(1L);

        Sector sector2 = new Sector();
        sector2.setName("test2");
        sector2.setId(2L);
        sector2.setParent(sector1);
        sector2.setSectors(new HashSet<>());
        Set<Sector> childList = new HashSet<>();
        childList.add(sector2);

        sector1.setSectors(childList);
        sectorList.add(sector1);


        User user = new User();
        user.setName("test");
        user.setId(1L);
        Set<Sector> selectSectorsList = new HashSet<>();
        selectSectorsList.add(sector1);
        selectSectorsList.add(sector2);
        user.setSectors(selectSectorsList);

        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        when(sectorRepository.findByParentIsNull()).thenReturn(sectorList);

        UserFormDto result = userService.getUserDto(1L);
        Assertions.assertEquals(user.getName(), expectedResult.getName());
        Assertions.assertEquals(expectedResult.getSectorIdList().size(),result.getSectorIdList().size());
        Assertions.assertEquals(expectedResult.getSectors().size(),result.getSectors().size());
        Assertions.assertEquals(expectedResult.getSectors().get(0).getName(),result.getSectors().get(0).getName());
        Assertions.assertEquals(expectedResult.getSectors().get(1).getName(),result.getSectors().get(1).getName());
    }

}