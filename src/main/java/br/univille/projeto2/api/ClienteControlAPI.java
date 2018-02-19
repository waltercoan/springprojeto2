package br.univille.projeto2.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projeto2.dao.ClienteRepository;
import br.univille.projeto2.entity.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlAPI {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		cliente = clienteRepository.saveAndFlush(cliente);
		return new ResponseEntity<Cliente>(cliente,HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente) {
		cliente = clienteRepository.saveAndFlush(cliente);
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Cliente> removerCliente(@PathVariable("id") long id) {
		clienteRepository.delete(id);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> lista = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
	}

}
