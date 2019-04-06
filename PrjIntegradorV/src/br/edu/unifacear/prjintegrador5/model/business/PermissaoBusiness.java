package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.PermissaoDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Permissao;

public class PermissaoBusiness {
	private PermissaoDAO dao;
	
	public PermissaoBusiness() {
		dao = new PermissaoDAO();
	}
	
	public void inserir(Permissao p) throws BusinessException {
		Boolean aux = true;
		
		for(Permissao pe : dao.listar()) {
			if(p.getDescricao().equals(pe.getDescricao())) {
				aux = false;
				throw new BusinessException("Permiss�o j� cadastrada");
			} 
		}
		
		if(aux) {
			dao.inserir(p);
		}
	}
	
	public void alterar(Permissao p) throws BusinessException {
		Boolean aux = false;
		
		for(Permissao pe : dao.listar()) {
			if(p.getId() == pe.getId()) {
				aux = true;
				dao.alterar(p);
				break;
			} 
		}
		
		if(!aux) {
			throw new BusinessException("Imposs�vel alterar: Permiss�o n�o encontrada!");
		}
	}
	
	public List<Permissao> listar() throws BusinessException {
		List<Permissao> lista = new ArrayList<Permissao>();
		
		if(dao.listar().size() < 1) {
			throw new BusinessException("N�o h� permiss�es cadastradas!");
		} else {
			lista = dao.listar();
		}
		return lista;
	}
	
	public void excluir(Permissao p) throws BusinessException {
		if(dao.obter(p.getId()).getDescricao().equals("") ) {
			throw new BusinessException("Permiss�o n�o encontrada!");
		} else {
			dao.excluir(p);	
		}
	}
	
	
	public Permissao obter(int id) throws BusinessException {
		Permissao e = new Permissao();
		
		if(dao.obter(id).getDescricao().equals("")) {
			throw new BusinessException("Permiss�o n�o encotrada!");
		} else {
			e = dao.obter(id);
		}
		return e;
	}
}
