package br.univille.projeto2.dao;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import br.univille.projeto2.entity.Item;

@Component
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter{

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Item.class,ClienteRepository.class);
		
	}
}
