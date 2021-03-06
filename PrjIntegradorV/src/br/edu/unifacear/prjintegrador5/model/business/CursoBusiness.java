package br.edu.unifacear.prjintegrador5.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.prjintegrador5.model.dao.CursoDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Curso;

public class CursoBusiness {
	private CursoDAO dao;

	public CursoBusiness() {
		dao = new CursoDAO();
	}

	public void inserir(Curso c) throws BusinessException {
		if (dao.listar().size() < 1) {
			dao.inserir(c);
		} else {
			Boolean aux = false;

			for (Curso cs : dao.listar()) {
				if (cs.getDescricao().equals(c.getDescricao())) {
					aux = true;
					break;
				}
			}

			if (!aux) {
				dao.inserir(c);
			} else {
				throw new BusinessException("Curso j� cadastrado!");
			}
		}
	}

	public void alterar(Curso c) throws BusinessException {
		Boolean aux = false;

		for (Curso cs : dao.listar()) {
			if (cs.getId() == c.getId()) {
				dao.alterar(c);
				aux = true;
				break;
			}
		}

		if (!aux) {
			throw new BusinessException("Imposs�vel alterar: Curso n�o encontrado!");
		}
	}

	public List<Curso> listar() throws BusinessException {
		List<Curso> lista = new ArrayList<Curso>();

		if (dao.listar().size() < 1) {
			throw new BusinessException("N�o h� cursos cadastrados");
		} else {
			lista = dao.listar();
		}

		return lista;
	}

	public Curso obter(int id) throws BusinessException {
		Curso c = new Curso();

		if (dao.obter(id).getId() == null) {
			throw new BusinessException("Curso n�o encontrado!");
		} else {
			c = dao.obter(id);
		}

		return c;
	}

	public List<Curso> obter(String descricao) throws BusinessException {
		List<Curso> lista = new ArrayList<Curso>();

		if (dao.obter(descricao).size() < 1) {
			throw new BusinessException("Curso n�o encontrado!");
		} else {
			lista = dao.obter(descricao);
		}

		return lista;
	}

	public void alterarStatus(int id) throws BusinessException {
		Curso c = dao.obter(id);
		if (c.getId() == null) {
			throw new BusinessException("Curso n�o encontrado!");
		} else {
			if (c.getStatus()) {
				c.setStatus(false);
			} else {
				c.setStatus(true);
			}

			dao.alterar(c);
		}
	}

	public void excluir(Curso c) throws BusinessException {
		if (dao.obter(c.getId()).getId() == null) {
			throw new BusinessException("Curso n�o encontrado!");
		} else {
			dao.excluir(c);
		}
	}
}

