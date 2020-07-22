/**
 * 
 */
package com.aztra.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 38609
 *
 */
@SpringBootApplication(scanBasePackages = { "com.aztra.springboot" }, exclude = { SecurityAutoConfiguration.class })
@ComponentScan("com.aztra.springboot")
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
