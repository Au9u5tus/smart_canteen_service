package com.yuhao.canteen;

import cn.hutool.core.util.NumberUtil;
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
	@Test
	void test(){
		//System.out.println(NumberUtil.decimalFormat("0.0",3.12455666f));
		 System.out.print(String.valueOf(Math.random()).substring(2,5));
	}

}
