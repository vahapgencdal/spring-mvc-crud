package com.helmes;

import com.helmes.model.Sector;
import com.helmes.repository.SectorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Slf4j
class SectorRepositoryTest {

	@Autowired
	private SectorRepository sectorRepository;

	@BeforeEach
	public void insertData(){
		Sector sector1 = new Sector();
		sector1.setName("test1");
		Sector sector2 = new Sector();
		sector2.setName("test2");
		sectorRepository.save(sector1);
		sectorRepository.save(sector2);
	}

	@Test
	public void findByIdInTest(){
		List<Sector> result = sectorRepository.findByIdIn(Arrays.asList(1L));
		Assertions.assertEquals(1, result.size());
		Assertions.assertEquals("test1", result.get(0).getName());
	}

	@Test
	public void findByParentIsNull(){
		List<Sector> result = sectorRepository.findByParentIsNull();
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals("test1", result.get(0).getName());
	}

}
