package com.yuhao.canteen;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootTest
class StartApplicationTests {

	@Test
	void contextLoads() {

				SecureRandom secureRandom = new SecureRandom();
				byte[] keyBytes = new byte[32]; // 32 字节 = 256 位
				secureRandom.nextBytes(keyBytes);
				String secretKey = Base64.getEncoder().encodeToString(keyBytes);
				System.out.println("生成的密钥: " + secretKey);

	}

}
