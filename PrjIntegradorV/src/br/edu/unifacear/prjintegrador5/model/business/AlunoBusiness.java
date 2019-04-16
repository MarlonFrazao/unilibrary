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
		List<Aluno> lista = new ArrayList<Aluno>();

		if (lista.size() < 1) {
			dao.inserir(a);
		} else {
			Boolean aux = false;

			for (Aluno al : lista) {
				if (al.getMatricula() == a.getMatricula()) {
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

  public void alterar(Aluno a) throws BusinessException{
     Boolean aux = false;

     if(dao.obterPorId(a.getId()).getId() == null) {
         aux = false;
     } else {
         aux = true;
     }

     if(aux) {
         dao.alterar(a);
     } else {
         throw new BusinessException ("Aluno não encontrado!");
     }
  }
}
