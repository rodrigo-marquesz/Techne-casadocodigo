package br.com.casadocodigo.loja.models;


import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String titulo;
	@Lob
	@Length(min = 10)
	@NotBlank
	private String descricao;

	@DecimalMin("20")
	private BigDecimal preco;

	@Min(50)
	private Integer numeroPaginas;

	@Temporal(TemporalType.DATE)
	private Calendar dataPublicacao;

	private String capaPath;
	@ManyToMany
	@Size(min = 1)
	@NotNull
	private List<Autor> autores = new ArrayList<>();


	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getCapaPath() {
		return capaPath;
	}

	public void setCapaPath(String capaPath) {
		this.capaPath = capaPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Livro: " +
				"\nid:" + id +
				"\ntitulo: " + titulo +
				"\ndescricao: " + descricao +
				"\npreco: " + preco +
				"\nnumeroPaginas: " + numeroPaginas +
				"\ndataPublicacao: " + dataPublicacao +
				"\ncapaPath: " + capaPath +
				"\nautores: " + autores;
	}
}
