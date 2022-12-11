package br.com.casadocodigo.loja.beans;


import br.com.casadocodigo.loja.conf.FacesContextProducer;
import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Named
@RequestScoped
public class AdminLivrosBean {

	@Inject
	private LivroDao dao;
	@Inject
	private AutorDao autorDao;
	@Inject
	private FacesContextProducer context;
	private Part capaLivro;
	private Livro livro = new Livro();


	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<Autor> getAutores(){
		return autorDao.listar();
	}
	public Part getCapaLivro() {
		return capaLivro;
	}
	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}

	@Transactional
	public String salvar() {
		dao.salvar(livro);

		FileSaver fileSaver = new FileSaver();

		livro.setCapaPath(fileSaver.write(capaLivro, "livros"));

		context.getFacesContext().getExternalContext()
				.getFlash().setKeepMessages(true);
		context.getFacesContext().addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));

		return "/livros/lista?faces-redirect=true";
	}
}
