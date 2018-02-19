package br.univille.projeto2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import br.univille.projeto2.dao.ClienteRepository;
import br.univille.projeto2.entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Projeto2ApplicationTests {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void buscaClientes() {
		Page<Cliente> clientes = 
				clienteRepository.findAll(new PageRequest(0, 10));
		assertThat(clientes.getTotalElements()).isEqualTo(1L);
	}
	

}
