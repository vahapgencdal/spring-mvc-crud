package com.helmes;

import com.helmes.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UtilTest {


	@Test
	void leftPadTest(){
		String str = Util.leftPad("test", 1);
		Assertions.assertEquals(Util.SPACE + "test",str);
	}

}
