package br.edu.unifacear.prjintegrador5.model.business;

import br.edu.unifacear.prjintegrador5.model.dao.UsuarioDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Usuario;

public class UsuarioBusiness {
	private UsuarioDAO dao;
	
	public UsuarioBusiness() {
		dao = new UsuarioDAO();
	}
	
	public void inserir(Usuario u) throws BusinessException {
		Usuario us = dao.obterPorUsuario(u.getUsuario());
		
		if(us.getUsuario() != null) {
			throw new BusinessException("Usuario ja cadastrado!");
		} else {
			try {
				dao.inserir(u);
			} catch(Exception e) {
				throw new BusinessException("Erro na conexão com o banco de dados: " + e.getMessage());
			}
		}
	}
}
