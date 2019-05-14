package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.LogAcessoDAO;
import br.edu.unifacear.prjintegrador5.model.entity.LogAcesso;
import br.edu.unifacear.prjintegrador5.model.entity.Usuario;

public class LogAcessoBusiness {
	private LogAcessoDAO dao;
	
	public LogAcessoBusiness() {
		dao = new LogAcessoDAO();
	}
	
	public void inserir(LogAcesso l) throws BusinessException {
		List<LogAcesso> lista = dao.obter(l.getUsuario());
		Boolean aux = false;
		
		if (lista.size() < 1) {
			dao.inserir(l);
		} else {
			for (LogAcesso la : lista) {
				if (la.getInicio().equals(l.getInicio()) && la.getFim().equals(l.getFim())) {
					aux = false;
					break;
				} else {
					aux = true;
				}
			}

			if (aux) {
				dao.inserir(l);
			} else {
				throw new BusinessException("Acesso duplicado!");
			}
		}

	}
	
	public void alterar(LogAcesso l) throws BusinessException {

		if (dao.obter(l.getId()).getId() == null) {
			throw new BusinessException("Log nao encontrado!");
		} else {

			dao.alterar(l);

		}
	}
	
	public List<LogAcesso> listar() throws BusinessException {
		List<LogAcesso> lista = dao.listar();
		
		if(lista.size() < 1) {
			throw new BusinessException("Sem logs cadastrados ou banco de dados indisponivel!");
		}
		
		return lista;
	}
	
	public LogAcesso obter(int id) throws BusinessException {
		LogAcesso l = dao.obter(id);
		
		if(l.getId() == null) {
			throw new BusinessException("Log nao encontrado!");
		} 
		
		return l;
	}
	
	public List<LogAcesso> obter(Usuario u) throws BusinessException {
		List<LogAcesso> lista = dao.obter(u);
		
		if(lista.size() < 1) {
			throw new BusinessException("Log nao encontrado!");
		}
		
		return lista;
	}
	
	public void excluir(LogAcesso l ) throws BusinessException {
		if(dao.obter(l.getId()).getId() == null) {
			throw new BusinessException("Log nao encontrado!");
		} else {
			dao.excluir(l);
		}
	}
}
