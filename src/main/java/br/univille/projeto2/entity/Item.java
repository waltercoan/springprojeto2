package br.univille.projeto2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Length(min=2, max=30, message="O tamanho do nome deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull
	@Min(value=20,message="O valor mínimo deve ser {value} reais")
	private double preco;

	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item( String nome, double preco) {
		setNome(nome);
		setPreco(preco);
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
