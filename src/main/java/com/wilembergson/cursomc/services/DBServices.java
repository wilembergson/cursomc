package com.wilembergson.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wilembergson.cursomc.domain.Categoria;
import com.wilembergson.cursomc.domain.Cidade;
import com.wilembergson.cursomc.domain.Cliente;
import com.wilembergson.cursomc.domain.Endereco;
import com.wilembergson.cursomc.domain.Estado;
import com.wilembergson.cursomc.domain.ItemPedido;
import com.wilembergson.cursomc.domain.Pagamento;
import com.wilembergson.cursomc.domain.PagamentoComBoleto;
import com.wilembergson.cursomc.domain.PagamentoComCartao;
import com.wilembergson.cursomc.domain.Pedido;
import com.wilembergson.cursomc.domain.Produto;
import com.wilembergson.cursomc.domain.enums.EstadoPagamento;
import com.wilembergson.cursomc.domain.enums.TipoCliente;
import com.wilembergson.cursomc.repositories.CategoriaRepository;
import com.wilembergson.cursomc.repositories.CidadeRepository;
import com.wilembergson.cursomc.repositories.ClienteRepository;
import com.wilembergson.cursomc.repositories.EnderecoRepository;
import com.wilembergson.cursomc.repositories.EstadoRepository;
import com.wilembergson.cursomc.repositories.ItemPedidoRepository;
import com.wilembergson.cursomc.repositories.PagamentoRepository;
import com.wilembergson.cursomc.repositories.PedidoRepository;
import com.wilembergson.cursomc.repositories.ProdutoRepository;

@Service
public class DBServices {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		Categoria catt1 = new Categoria(null, "Informatica");
		Categoria catt2 = new Categoria(null, "Escritorio");
		Categoria catt3 = new Categoria(null, "Cama mesa e banho");
		Categoria catt4 = new Categoria(null, "Eletrônicos");
		Categoria catt5 = new Categoria(null, "Jardinagem");
		Categoria catt6 = new Categoria(null, "Decoração");
		Categoria catt7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritorio", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV True color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		catt1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		catt2.getProdutos().addAll(Arrays.asList(p2, p4));
		catt3.getProdutos().addAll(Arrays.asList(p5, p6));
		catt4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		catt5.getProdutos().addAll(Arrays.asList(p8));
		catt6.getProdutos().addAll(Arrays.asList(p9,p10));
		catt7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(catt1, catt4));
		p2.getCategorias().addAll(Arrays.asList(catt1, catt2, catt4));
		p3.getCategorias().addAll(Arrays.asList(catt1, catt4));
		p4.getCategorias().addAll(Arrays.asList(catt2));
		p5.getCategorias().addAll(Arrays.asList(catt3));
		p6.getCategorias().addAll(Arrays.asList(catt3));
		p7.getCategorias().addAll(Arrays.asList(catt4));
		p8.getCategorias().addAll(Arrays.asList(catt5));
		p9.getCategorias().addAll(Arrays.asList(catt6));
		p10.getCategorias().addAll(Arrays.asList(catt6));
		p11.getCategorias().addAll(Arrays.asList(catt7));
		
		
		categoriaRepository.saveAll(Arrays.asList(catt1, catt2, catt3, catt4, catt5, catt6, catt7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3, p4, p5, p6, p7, p8, p9, p10, p11));

		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "wilembergson@gmail.com", "36378912377", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedido().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}
