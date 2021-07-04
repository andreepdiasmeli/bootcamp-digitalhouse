package io.github.andreepdiasmeli.apiloja;

import io.github.andreepdiasmeli.apiloja.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiLojaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiLojaApplication.class, args);
	}

	@Autowired
	private DBService dbService;

	@Override
	public void run(String... args) throws Exception {
		dbService.instantiateDB();
	}
}
