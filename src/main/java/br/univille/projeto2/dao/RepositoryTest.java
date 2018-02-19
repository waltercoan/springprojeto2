package br.univille.projeto2.dao;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.univille.projeto2.entity.Cliente;
import br.univille.projeto2.entity.Item;
import br.univille.projeto2.entity.Pedido;

@Component
//@Profile("!prod")
public class RepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostConstruct
	public void init() {
		System.out.println("RRRRUUUUUNNNNN!!!!");
		Cliente pedro = new Cliente(01,"Pedro","São Paulo");
		
		Item dog1 = new Item("Green Dog Trad", 25d);
		
		Pedido ped = new Pedido();
		ped.setItens(new ArrayList<Item>());
		ped.setCliente(pedro);
		ped.setData(new Date());
		ped.getItens().add(dog1);
		ped.setValorTotal(25d);
		
		clienteRepository.saveAndFlush(pedro);
		
		pedidoRepository.saveAndFlush(ped);
				
		
		
		
		
	}
}
