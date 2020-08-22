package com.wilembergson.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wilembergson.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria catt1 = new Categoria(1, "Informatica");
		Categoria catt2 = new Categoria(2, "Escritorio");
		
		List<Categoria> lista =  new ArrayList<>();
		lista.add(catt1);
		lista.add(catt2);
		
		return lista;
	}
}
