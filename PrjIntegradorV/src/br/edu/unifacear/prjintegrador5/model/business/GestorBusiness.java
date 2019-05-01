package br.edu.unifacear.prjintegrador5.model.business;

import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.GestorDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Funcionario;
import br.edu.unifacear.prjintegrador5.model.entity.Gestor;

public class GestorBusiness {
	private GestorDAO dao;
	
	public GestorBusiness() {
		dao = new GestorDAO();
	}
	
	public void inserir(Gestor g) throws BusinessException {
		Gestor gt = dao.obterPorUsuario(g.getUsuario());
		
		if(gt.getUsuario() != null) {
			throw new BusinessException("Gestor ja cadastrado!");
		} else {
			dao.inserir(g);
		}
	}
	
	public void alterar(Gestor g) throws BusinessException {
		Gestor gt = dao.obterPorId(g.getId());
		
		if(gt.getId() == null) {
			throw new BusinessException("Gestor nao encontrado!");
		} else {
			dao.alterar(g);
		}
	}
	
	public List<Gestor> listar() throws BusinessException {
		List<Gestor> lista = dao.listar();
		
		if(lista.size() < 1) {
			throw new BusinessException("Nao ha gestores cadastrados!");
		} 
		
		return lista;
	}
	
	public Gestor obterPorId(int id) throws BusinessException  {
		Gestor g = dao.obterPorId(id);
		
		if(g.getId() == null) {
			throw new BusinessException("Gestor nao encontrado!");
		}
		
		return g;
	}
	
	public Gestor obterPorUsuario(int usuario) throws BusinessException  {
		Gestor g = dao.obterPorUsuario(usuario);
		
		if(g.getId() == null) {
			throw new BusinessException("Gestor nao encontrado!");
		}
		
		return g;
	}
	
	public Gestor obterPorFuncionario(Funcionario f) throws BusinessException {
		Gestor g = dao.obterPorFuncionario(f);
		
		if(g.getId() == null) {
			throw new BusinessException("Gestor nao encontrado!");
		}
		
		return g;
	}
	
	public void alterarStatus(Gestor g)  throws BusinessException {
		Gestor gt = dao.obterPorId(g.getId());
		
		if(gt.getId() == null) {
			throw new BusinessException("Gestor nao encontrado!");
		} else {
			if(gt.getStatus()) {
				gt.setStatus(false);
			} else {
				gt.setStatus(true);
			}
			
			dao.alterar(gt);
		}
	}
	
	public void excluir(Gestor g) throws BusinessException {
		Gestor gt = dao.obterPorId(g.getId());
		
		if(gt.getId() == null) {
			throw new BusinessException("Gestor nao encontrado!");
		} else {
			dao.excluir(g);
		}
	}
	
	public Boolean login(int usuario, int senha) throws BusinessException {
		Gestor g = dao.obterPorUsuario(usuario);
		
		Boolean aceito = false;
		
		if(g.getId() == null) {
			throw new BusinessException("Gestor nao encontrado!");
		} else {
			if(g.getSenha() == senha) {
				aceito = true;
			} else {
				aceito = false;
			}
		}
		
		return aceito;
	}
}
