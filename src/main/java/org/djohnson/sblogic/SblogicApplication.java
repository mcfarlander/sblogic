package org.djohnson.sblogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages={"org.djohnson.sblogic"})
@EntityScan(basePackages="{org.djohnson.sblogic.model")
@EnableJpaRepositories(basePackages="{org.djohnson.sblogic.respository")
@EnableTransactionManagement
public class SblogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SblogicApplication.class, args);
	}

}
