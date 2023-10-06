package com.sinensia.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase de configuracion
 * 
 * @authorSergio
 * @see com.sinensia.controller.CursoController
 * @see com.sinensia.service.CursoServiceImpl
 * @see com.sinensia.model.Curso
 */
@EntityScan(basePackages = "com.sinensia.model")
@EnableJpaRepositories(basePackages = "com.sinensia.dao")
@SpringBootApplication(scanBasePackages = { "com.sinensia.controller", "com.sinensia.service" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
