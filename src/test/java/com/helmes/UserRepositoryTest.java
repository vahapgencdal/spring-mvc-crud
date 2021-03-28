package com.helmes;

import com.helmes.model.Sector;
import com.helmes.model.User;
import com.helmes.repository.SectorRepository;
import com.helmes.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Slf4j
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SectorRepository sectorRepository;

	@BeforeEach
	@Transactional
	public void insertData(){
		User user1 = new User();
		user1.setName("test1");
		user1.setAgreeTerms(Boolean.TRUE);
		User user2 = new User();
		user2.setName("test2");
		user2.setAgreeTerms(Boolean.TRUE);

		Sector sector1 = new Sector();
		sector1.setName("test1");
		Sector sector2 = new Sector();
		sector2.setName("test2");

		sectorRepository.save(sector1);
		sectorRepository.save(sector2);

		List<Sector> result1 = sectorRepository.findByIdIn(Arrays.asList(1L));
		user1.setSectors(new HashSet<>(result1));

		List<Sector> result2 = sectorRepository.findByIdIn(Arrays.asList(2L));
		user2.setSectors(new HashSet<>(result2));

		userRepository.save(user1);
		userRepository.save(user2);
	}

	@Test
	public void findAllTest(){
		List<User> result = userRepository.findAll();
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals("test1", result.get(0).getName());
	}

}
