package com.github.sba.authentication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@ComponentScan(basePackages = { "com.github.sba.authentication.**.service.*",
		"com.github.sba.authentication.security" })
@EnableConfigurationProperties
@ActiveProfiles(profiles = "junit")
public class SbaAuthenticationApplicationTests {

	@Test
	public void contextLoads() {
	}

}
