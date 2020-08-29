package com.wilembergson.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilembergson.cursomc.domain.Pedido;
import com.wilembergson.cursomc.repositories.PedidoRepository;
import com.wilembergson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Pedido.class.getName()));	
	}
}
