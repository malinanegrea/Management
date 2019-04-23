package com.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@ComponentScan("persistence.DAO")
@EntityScan("persistence.entity")
@EnableJpaRepositories(basePackages="persistence.DAO", entityManagerFactoryRef="UserRepository")*/
@SpringBootApplication
@EnableAutoConfiguration
public class ProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjApplication.class, args);
	}

}
