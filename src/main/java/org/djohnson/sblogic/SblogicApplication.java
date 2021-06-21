package org.djohnson.sblogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"org.djohnson.sblogic"})
public class SblogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SblogicApplication.class, args);
	}

}
