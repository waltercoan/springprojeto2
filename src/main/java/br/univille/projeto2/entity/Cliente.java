package br.univille.projeto2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Length(min=2, max=100, message="O tamanho do nome deve ser entre {min} e {max}")
	private String nome;
	@NotNull
	@Length(min=2, max=300, message="O tamanho do endereço deve ser entre {min} e {max}")
	private String endereco;
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Cliente() {
	}
	
	public Cliente(int id, String nome, String endereco) {
		setId(id);
		setNome(nome);
		setEndereco(endereco);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
}
