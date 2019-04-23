package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

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
	
	public void alterar(Usuario u) throws BusinessException {
		if(dao.obterPorId(i.getId()).getId() == null) {
			throw new BusinessException("Usuario nao encontrado"!);
		} else {
			try {
				dao.alterar(u);
			} catch(Exception e) {
				throw new BusinessException("Erro na conexão com o banco de dados: " + e.getMessage());
			}
		}
	}
	
	public List<Usuario> listar() throws BusinessException {
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			lista = dao.listar();
		} catch(Exception e) {
			throw new BusinessException("Erro na conexão com o banco de dados: " + e.getMessage());
		}
		
		if(lista.size() < 1) {
			throw new BusinessException("Nao ha usuarios cadastrados");
		}
		
		return lista;
	}
	
	public Usuario obterPorId(int id) throws BusinessException {
		Usuario u = new Usuario();
		
		try {
			u = dao.obterPorId(id);
		} catch(Exception e) {
			throw new BusinessException("Erro na conexão com o banco de dados: " + e.getMessage());
		}
		
		if(u.getId() == null) {
			throw new BusinessException("Usuario nao encontrado!");
		}
		
		return u;
	}
	
	public Usuario obterPorUsuario(int usuario) throws BusinessException {
		Usuario u = new Usuario();
		
		try {
			u = dao.obterPorUsuario(usuario);
		} catch(Exception e) {
			throw new BusinessException("Erro na conexão com o banco de dados: " + e.getMessage());
		}
		
		if(u.getId() == null) {
			throw new BusinessException("Usuario nao encontrado!");
		}
		
		return u;
	}
	
	public void alterarStatus(Usuario u) throws BusinessException {
		Usuario us = new Usuario();
		
		try {
			us = dao.obterPorId(u.getId());
			
			if(us.getId() != null) {
				if(us.getStatus) {
					u.setStatus(false);
				} else {
					u.setStatus(true);
				}
			
				dao.alterar(u);
			} else {
				throw new BusinessException("Usuario nao encontrado!");
			}
		} catch(Exception e) {
			throw new BusinessException("Erro na conexão com o banco de dados: " + e.getMessage());
		}
	}
	
	public void excluir(Usuario u) throws BusinessException {
		try {
			if(dao.obterPorId(u.getId()).getId() == null) {
				throw new BusinessException("Usuario nao encontrado!");
			} else {
				dao.excluir(u);
			}
		} catch(Exception e) {
			throw new BusinessException("Erro na conexão com o banco de dados: " + e.getMessage());
		}
	}
	
	public Boolean login(int usuario, int senha)  throws BusinessException {
		Boolean aceito = false;
		
		try {
			Usuario u = dao.obterPorUsuario(usuario);
			
			if(u.getId() == null) {
				throw new BusinessException("Usuario nao encontrado!");
			} else {
				if(u.getSenha() == senha) {
					aceito = true;
				} else {
					aceito = false;
				}
			}
		} catch(Exception e) {
			throw new BusinessException("Erro na conexão com o banco de dados: " + e.getMessage());
		}
		
		return aceito;
	}
}
