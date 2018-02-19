package br.univille.projeto2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.univille.projeto2.entity.Item;
@RepositoryRestResource(collectionResourceRel="itens", path="itens")
public interface ItemRepository extends JpaRepository<Item, Long>{

}
