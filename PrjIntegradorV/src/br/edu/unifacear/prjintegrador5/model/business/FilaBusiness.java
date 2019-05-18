package br.edu.unifacear.prjintegrador5.model.business;

import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.FilaDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Fila;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

public class FilaBusiness {
	private FilaDAO dao;
	
	public FilaBusiness() {
		dao = new FilaDAO();
	}
	
	public void inserir(Fila f) {
		dao.inserir(f);
	}
	
	public void alterar(Fila f) throws BusinessException {
		if(dao.obter(f.getId()).getId() == null) {
			throw new BusinessException("Posicao nao encontrada!");
		} else {
			dao.alterar(f);
		}
	}
	
	public List<Fila> listar() throws BusinessException {
		List<Fila> lista = dao.listar();
		
		if(lista.size() < 1) {
			throw new BusinessException("Nao ha posicoes cadastradas!");
		} else {
			return lista;
		}
	}
	
	public Fila obter(int id) throws BusinessException {
		Fila f = dao.obter(id);
		
		if(f.getId() == null) {
			throw new BusinessException("Posicao nao encontrada!");
		} else {
			return f;
		}
	}
	
	public List<Fila> obter(Livro l) throws BusinessException {
		List<Fila> lista = dao.obter(l);
		
		if(lista.size() < 1) {
			throw new BusinessException("Sem fila de espera para o livro " + l.getTitulo());
		} else {
			return lista;
		}
	}
	
	public void excluir(Fila f) throws BusinessException {
		if(dao.obter(f.getId()).getId() == null) {
			throw new BusinessException("Posicao nao encontrada!");
		} else {
			dao.excluir(f);
		}
	}
}
