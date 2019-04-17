package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.AlunoDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Aluno;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;

public class AlunoBusiness {
	private AlunoDAO dao;

	public AlunoBusiness() {
		dao = new AlunoDAO();
	}

	public void inserir(Aluno a) throws BusinessException {
		List<Aluno> lista = dao.listar();
		
		if (lista.size() < 1) {
			dao.inserir(a);
		} else {
			Boolean aux = false;

			for (Aluno al : lista) {
				if (al.getMatricula().equals(a.getMatricula())) {
					aux = false;
					break;
				} else {
					aux = true;
				}
			}

			if (aux) {
				dao.inserir(a);
			} else {
				throw new BusinessException("Aluno ja cadastrado!");
			}
		}
	}

	public void alterar(Aluno a) throws BusinessException {
		Boolean aux = false;

		if (dao.obterPorId(a.getId()).getId() == null) {
			aux = false;
		} else {
			aux = true;
		}

		if (aux) {
			dao.alterar(a);
		} else {
			throw new BusinessException("Aluno nÃ£o encontrado!");
		}
	}
	
	public List<Aluno> listar() throws BusinessException {
		List<Aluno> lista = new ArrayList<Aluno>();
		
		if(dao.listar().size() < 1) {
			throw new BusinessException("Não há alunos cadastrados!");
		} else {
			lista = dao.listar();
		}
		
		return lista;
	}
	
	public Aluno obterPorId(int id) throws BusinessException {
		Aluno a = new Aluno();
		
		if(dao.obterPorId(id).getId() == null) {
			throw new BusinessException("Aluno não encontrado!");
		} else {
			a = dao.obterPorId(id);
		}
		
		return a;
	}
	
	public List<Aluno> obterPorNome(String nome) throws BusinessException {
		List<Aluno> lista = new ArrayList<Aluno>();
		
		if(dao.obterPorNome(nome).size() < 1) {
			throw new BusinessException("Aluno não encontrado!");
		} else {
			lista = dao.obterPorNome(nome);
		}
		
		return lista;
	} 
	
	public Aluno obterPorEmail(String email) throws BusinessException {
		Aluno a = new Aluno();
		
		if(dao.obterPorEmail(email).getId() == null) {
			throw new BusinessException("Aluno não encontrado!");
		} else {
			a = dao.obterPorEmail(email);
		}
		
		return a;
	}
	
	public Aluno obterPorMatricula(int mat) throws BusinessException {
		Aluno a = new Aluno();
		
		if(dao.obterPorMatricula(mat).getId() == null) {
			throw new BusinessException("Aluno não encontrado!");
		} else {
			a = dao.obterPorMatricula(mat);
		}
		
		return a;
	}
	
	public List<Aluno> obterPorCurso(Curso c) throws BusinessException {
		List<Aluno> lista = new ArrayList<Aluno>();
		
		if(dao.obterPorCurso(c).size() < 1) {
			throw new BusinessException("Não encontrado alunos nesse curso!");
		} else {
			lista = dao.obterPorCurso(c);
		}
		return lista;
	}
	
	public void alterarStatus(int id) throws BusinessException {
		Aluno a = dao.obterPorId(id);
			
		if(a.getId() == null) {
			throw new BusinessException("Aluno não encontrado!");
		} else {
			if(a.getStatus()) {
				a.setStatus(false);
			} else {
				a.setStatus(true);
			}
			
			dao.alterar(a);
		}
	}
	
	public void excluir(Aluno a) throws BusinessException {
		if(dao.obterPorId(a.getId()).getId() == null) {
			throw new BusinessException("Aluno não encontrado!");
		} else {
			dao.excluir(a);
		}
	}
}
