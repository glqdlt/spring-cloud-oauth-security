package com.glqdlt.ex.oauthauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.glqdlt.ex.**")
@SpringBootApplication
public class OauthAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthAuthServerApplication.class, args);
	}

}
