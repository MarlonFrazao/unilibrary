package br.edu.unifacear.prjintegrador5.model.business;

import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.AgendarEmprestimoDAO;
import br.edu.unifacear.prjintegrador5.model.entity.AgendarEmprestimo;
import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Fila;

public class AgendarEmprestimoBusiness {
	private AgendarEmprestimoDAO dao;
	
	public AgendarEmprestimoBusiness() {
		dao = new AgendarEmprestimoDAO();
	}
	
	public void inserir(AgendarEmprestimo a) throws BusinessException {
		List<AgendarEmprestimo> lista = dao.obter(a.getAluno());
		
		if(lista.size() < 1) {
			dao.inserir(a);
		} else {
			Boolean aux = false;
			
			for(AgendarEmprestimo ae : lista) {
				if(ae.getFila().getId() == a.getFila().getId()) {
					aux = false;
					break;
				} else {
					aux = true;
				}
			}
			
			if(aux) {
				dao.inserir(a);
			} else {
				throw new BusinessException("Emprestimo ja agendado!");
			}
		}
	}
	
	public void alterar(AgendarEmprestimo a) throws BusinessException {
		if(dao.obter(a.getId()).getId() == null) {
			throw new BusinessException("Agendamento nao encontrado!");
		} else {
			dao.alterar(a);
		}
	}
	
	public List<AgendarEmprestimo> listar() throws BusinessException {
		List<AgendarEmprestimo> lista = dao.listar();
		
		if(lista.size() < 1) {
			throw new BusinessException("Nao ha emprestimos agendados");
		}
		
		return lista;
	}
	
	public AgendarEmprestimo obter(int id) throws BusinessException {
		if(dao.obter(id).getId() == null) {
			throw new BusinessException("Agendamento nao encontrado!");
		}
		
		return dao.obter(id);
	}
	
	public List<AgendarEmprestimo> obter(Aluno a) throws BusinessException {
		List<AgendarEmprestimo> lista = dao.obter(a);
		
		if(lista.size() < 1) {
			throw new BusinessException("Nao ha emprestimos agendados para o aluno " + a.getNome());
		}
		
		return lista;
	}
	
	public AgendarEmprestimo obter(Fila f) throws BusinessException {
		if(dao.obter(f).getId() == null) {
			throw new BusinessException("Agendamento nao encontrado!");
		}
		
		return dao.obter(f);
	}
	
	public void excluir(AgendarEmprestimo a) throws BusinessException {
		if(dao.obter(a.getId()).getId() == null) {
			throw new BusinessException("Agendamento nao encontrado!");
		} else {
			dao.excluir(a);
		}
	}
}
