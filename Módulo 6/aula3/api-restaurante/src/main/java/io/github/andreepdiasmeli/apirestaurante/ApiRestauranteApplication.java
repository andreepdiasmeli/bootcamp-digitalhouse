package io.github.andreepdiasmeli.apirestaurante;

import io.github.andreepdiasmeli.apirestaurante.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestauranteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestauranteApplication.class, args);
	}

	@Autowired
	private DBService dbService;

	@Override
	public void run(String... args) throws Exception {
		dbService.instantiateDB();
	}
}

