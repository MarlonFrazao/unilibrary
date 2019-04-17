package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.AutorDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Autor;

public class AutorBusiness {
	private AutorDAO dao;
	
	public AutorBusiness() {
		dao = new AutorDAO();
	}
	
	public void inserir(Autor a) throws BusinessException {
		List<Autor> lista = dao.listar();
		
		if(lista.size() < 1) {
			dao.inserir(a);
		} else {
			Boolean aux = false;
			for(Autor at : lista) {
				if(at.getNome().equals(a.getNome())) {
					aux = false;
					throw new BusinessException("Autor já cadastrado!");
				} else {
					aux = true;
				}
			}
			
			if(aux) {
				dao.inserir(a);
			}
		}
	}
	
	public void alterar(Autor a) throws BusinessException {
		Boolean aux = false;
		
		for(Autor at : dao.listar()) {
			if(a.getId() == at.getId()) {
				aux = true;
				dao.alterar(a);
				break;
			}
		}
		
		if(!aux) {
			throw new BusinessException("Impossível alterar: Autor não encontrada!");
		}
	}
	
	public List<Autor> listar() throws BusinessException {
		List<Autor> lista = new ArrayList<Autor>();
		
		if(dao.listar().size() < 1) {
			throw new BusinessException("Não há autores cadastrados!");
		} else {
			lista = dao.listar();
		}
		
		return lista;
	}
	
	public Autor obter(int id) throws BusinessException {
		Autor a = new Autor();
		
		if(dao.obter(id).getId() == null) {
			throw new BusinessException("Autor n�o encontrado!");
		} else {
			a = dao.obter(id);
		}
		
		return a;
	}
	
	public List<Autor> obter(String nome) throws BusinessException {
		List<Autor> lista = new ArrayList<Autor>();
		
		if(dao.obter(nome).size() < 1) {
			throw new BusinessException("Autor não encontrado!");
		} else {
			lista = dao.obter(nome);
		}
		
		return lista;
	}
	
	public void excluir(Autor a) throws BusinessException {
		if(dao.obter(a.getId()).getNome().equals("")) {
			throw new BusinessException("Autor não encontrado!");
		} else {
			dao.excluir(a);
		}
	}
 }
