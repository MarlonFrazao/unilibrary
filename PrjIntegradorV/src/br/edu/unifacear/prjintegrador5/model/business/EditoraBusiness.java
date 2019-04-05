package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.EditoraDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Editora;

public class EditoraBusiness{
	private EditoraDAO dao;
	
	public EditoraBusiness() {
		dao = new EditoraDAO();
	}
	
	public void inserir(Editora e) throws BusinessException {
		List<Editora> lista = dao.listar();
		
		if(lista.size() < 1){
			dao.inserir(e);
		} else {
			boolean aux = false;
			for(Editora ed : lista) {
				if(ed.getRazaoSocial().equals(e.getRazaoSocial())) {
					aux = true;
					break;
				}
			}
			
			if (aux) {
				throw new BusinessException("Editora j? cadastrada");
			} else {
				dao.inserir(e);
			}
		}
	}
	
	public void alterar(Editora e) throws BusinessException {
		Editora ed = dao.obter(e.getId());
		
		if(ed.getRazaoSocial().equals("")) {
			throw new BusinessException("Editora n?o encontrada!");
		} else {
			dao.alterar(e);
		}
	}
	
	public List<Editora> listar() throws BusinessException {
		List<Editora> lista = new ArrayList<Editora>();
		
		if(dao.listar().size() < 1) {
			throw new BusinessException("N?o h? editoras cadastradas!");
		} else {
			lista = dao.listar();
		}
		
		return lista;
	}
	
	public Editora obter(int id) throws BusinessException {
		Editora e = new Editora();
		
		if(dao.obter(id).getRazaoSocial().equals("")) {
			throw new BusinessException("Editora n?o encontrada!");
		} else {
			e = dao.obter(id);
		}
		
		return e;
	}
	
	public void excluir(Editora e) throws BusinessException {
		
		if(dao.obter(e.getId()).getRazaoSocial().equals("")) {
			throw new BusinessException("Editora n?o encontrada!");
		} else {
			dao.excluir(e);
		}
	}
}