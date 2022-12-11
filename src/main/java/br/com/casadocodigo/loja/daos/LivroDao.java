package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Livro;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Stateful
public class LivroDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    public void salvar(Livro livro){
        manager.persist(livro);
    }

    public List<Livro> listar() {

        String jpql = "select distinct(l) from Livro l" + " join fetch l.autores";

        return manager.createQuery(jpql, Livro.class).getResultList();
    }

    public List<Livro> ultimosLancamentos() {
        String jqpl = "select l from Livro l order by l.dataPublicacao desc";

        return manager.createQuery(jqpl, Livro.class).setMaxResults(5).getResultList();
    }

    public List<Livro> demaisLancamentos() {
        String jpql = "select l from Livro l order by l.titulo desc";

        return manager.createQuery(jpql, Livro.class).getResultList();
    }

    public Livro buscarPorId(Integer id) {

        String jpql = "select l from Livro l join fetch l.autores where l.id = :id";

        return manager.createQuery(jpql, Livro.class).setParameter("id", id).getSingleResult();
    }
}
