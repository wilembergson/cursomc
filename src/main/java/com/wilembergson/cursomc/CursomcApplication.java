package com.wilembergson.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wilembergson.cursomc.domain.Categoria;
import com.wilembergson.cursomc.domain.Produto;
import com.wilembergson.cursomc.repositories.CategoriaRepository;
import com.wilembergson.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria catt1 = new Categoria(null, "Informatica");
		Categoria catt2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		catt1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		catt2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(catt1));
		p2.getCategorias().addAll(Arrays.asList(catt1, catt2));
		p3.getCategorias().addAll(Arrays.asList(catt1));
		
		categoriaRepository.saveAll(Arrays.asList(catt1, catt2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
