package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.LivroDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Autor;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

public class LivroBusiness {
	private LivroDAO dao;
	
	public LivroBusiness() {
		dao = new LivroDAO();
	}
	
	public void inserir(Livro l) throws BusinessException {
		if(dao.listar().size() < 1) {
			dao.inserir(l);
		} else {
			Boolean aux = false;
			for(Livro li : dao.listar()) {
				if(l.getTitulo().equals(li.getTitulo())) {
					aux = true;
					break;
				}
			}
			
			if(aux) {
				throw new BusinessException("Livro já cadastrado!");
			} else {
				dao.inserir(l);
			}
		}
	}
	
	public void alterar(Livro l) throws BusinessException {
		Boolean aux = false;
		
		for (Livro li : dao.listar()) {
			if(l.getId() == li.getId()) {
				aux = true;
				dao.alterar(l);
				break;
			}
		}
		
		if(!aux) {
			throw new BusinessException("Impossível alterar: Livro não encontrado!");
		}
	}
	
	public List<Livro> listar() throws BusinessException {
		List<Livro> lista = new ArrayList<Livro>();
		
		if(dao.listar().size() < 1) {
			throw new BusinessException("Não há livros cadastrados!");
		} else {
			lista = dao.listar();
		}
		
		return lista;
	}
	
	public Livro obter(int id) throws BusinessException {
		Livro l = new Livro();
		
		if(dao.obter(id).getId() == null) {
			throw new BusinessException("Livro não encontrado!");
		} else {
			l = dao.obter(id);
		}
		
		return l;
	}
	
	public List<Livro> obter(String titulo) throws BusinessException {
		List<Livro> lista = new ArrayList<Livro>();
		
		if(dao.obter(titulo).size() < 1) {
			throw new BusinessException("Não há livros cadastrados!");
		} else {
			lista = dao.obter(titulo);
		}
		
		return lista;
	}
	
	public List<Livro> obter(Autor a) throws BusinessException {
		List<Livro> lista = new ArrayList<Livro>();
		
		if(dao.obter(a).size() < 1) {
			throw new BusinessException("Não há livros cadastrados!");
		} else {
			lista = dao.obter(a);
		}
		
		return lista;
	}
	
	public void excluir(Livro l) throws BusinessException {
		
		if(dao.obter(l.getId()).getTitulo().equals("")) {
			throw new BusinessException("Livro não encontrado!");
		} else {
			dao.excluir(l);
		}
	}
}
