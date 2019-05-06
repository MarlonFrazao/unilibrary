package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.EmprestimoDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Emprestimo;
import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

public class EmprestimoBusiness {
	private EmprestimoDAO dao;
	
	public EmprestimoBusiness() {
		dao = new EmprestimoDAO();
	}
	
	public void inserir(Emprestimo e) throws BusinessException {
		Boolean aux = false;
		
		for(Emprestimo em : dao.obter(e.getAluno())) {
			if(em.getLivro().equals(e.getLivro()) && em.getDataInicio().equals(e.getDataInicio())) {
				aux = false;
				break;
			} else {
				aux = true;
			}
		}
		
		if(aux) {
			dao.inserir(e);
		} else {
			throw new BusinessException("Emprestimo ja efetuado!");
		}
	}
	
	public void alterar(Emprestimo e) throws BusinessException {
		if(dao.obter(e.getId()).getId() == null) {
			throw new BusinessException("Emprestimo nao encontrado!");
		} else {
			dao.alterar(e);
		}
	}
	
	public List<Emprestimo> listar() throws BusinessException {
		List<Emprestimo> lista = dao.listar();
		
		if (lista.size() < 1) {
			throw new BusinessException("Nao ha emprestimos cadastrados!");
		}
		
		return lista;
	}
	
	public Emprestimo obter(int id) throws BusinessException {
		Emprestimo e = dao.obter(id);
		
		if(e.getId() == null) {
			throw new BusinessException("Emprestimo nao encontrado!");
		}
		
		return e;
	}
	
	public List<Emprestimo> obter(Aluno a) throws BusinessException {
		List<Emprestimo> lista = dao.obter(a);
		
		if(lista.size() < 1) {
			throw new BusinessException("Emprestimo nao encontrado!");
		}
		
		return lista;
	}
	
	public List<Emprestimo> obter(Livro l) throws BusinessException {
		List<Emprestimo> lista = dao.obter(l);
		
		if(lista.size() < 1) {
			throw new BusinessException("Emprestimo nao encontrado!");
		}
		
		return lista;
	}
	
	public void excluir(Emprestimo e) throws BusinessException {
		if(dao.obter(e.getId()).getId() == null) {
			throw new BusinessException("Emprestimo nao encontrado!");
		} else {
			dao.excluir(e);
		}
	}
}
