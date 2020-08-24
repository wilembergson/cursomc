package com.wilembergson.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wilembergson.cursomc.domain.Categoria;
import com.wilembergson.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria catt1 = new Categoria(null, "Informatica");
		Categoria catt2 = new Categoria(null, "Escritorio");
		
		categoriaRepository.saveAll(Arrays.asList(catt1, catt2));
	}

}
