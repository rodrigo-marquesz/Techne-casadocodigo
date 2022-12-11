package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class AdminListaLivrosBean {

    @Inject
    private LivroDao dao;
    private List<Livro> livros = new ArrayList<>();

    public List<Livro> getLivros() {
        livros = this.dao.listar();

        return livros;
    }


}
