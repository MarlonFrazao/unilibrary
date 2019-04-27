package br.edu.unifacear.prjintegrador5.model.business;

import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.FuncionarioDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Funcionario;

public class FuncionarioBusiness {
	private FuncionarioDAO dao;
	
	public FuncionarioBusiness() {
		dao = new FuncionarioDAO();
	}
	
	public void inserir(Funcionario f) throws BusinessException {
		Funcionario fu = dao.obterPorContrato(f.getContrato());
		
		if(fu.getId() != null) {
			throw new BusinessException("Funcionario ja cadastrado!");
		} else {
			dao.inserir(f);
		}	
	}
	
	public void alterar(Funcionario f) throws BusinessException {
		Funcionario fu = dao.obterPorId(f.getId());
		
		if(fu.getId() == null) {
			throw new BusinessException("Funcionario nao encontrado!");
		} else {
			dao.alterar(f);
		}	
	}
	
	public List<Funcionario> listar() throws BusinessException {
		List<Funcionario> lista = dao.listar();
		
		if(lista.size() < 1) {
			throw new BusinessException("Nao ha funcionarios cadastrados!");
		} 
		
		return lista;
	}
	
	public Funcionario obterPorId(int id) throws BusinessException {
		Funcionario f = dao.obterPorId(id);
		
		if(f.getId() == null) {
			throw new BusinessException("Funcionario nao encontrado!");
		}
		
		return f;
	}
	
	public List<Funcionario> obterPorNome(String nome) throws BusinessException {
		List<Funcionario> lista = dao.obterPorNome(nome);
		
		if(lista.size() < 1) {
			throw new BusinessException("Funcionario nao encontrado!");
		}
		
		return lista;
	}
	
	public Funcionario obterPorContrato(int contrato) throws BusinessException {
		Funcionario f = dao.obterPorContrato(contrato);
		
		if(f.getId() == null) {
			throw new BusinessException("Funcionario nao encontrado!");
		}
		
		return f;
	}
	
	public void alterarStatus(Funcionario f) throws BusinessException {
		
		if(dao.obterPorId(f.getId()).getId() == null) {
			throw new BusinessException("Funcionario nao encontrado!");
		} else {
			if(f.getStatus()) {
				f.setStatus(false);
			} else {
				f.setStatus(true);
			}
			
			dao.alterar(f);
		}
	}
	
	public void excluir(Funcionario f) throws BusinessException {
		
		if(dao.obterPorId(f.getId()).getId() == null) {
			throw new BusinessException("Funcionario nao encontrado!");
		} else {
			dao.excluir(f);
		}
	}
}
