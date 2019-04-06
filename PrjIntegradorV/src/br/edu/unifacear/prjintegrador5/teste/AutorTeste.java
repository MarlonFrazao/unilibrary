package br.edu.unifacear.prjintegrador5.teste;

import br.edu.unifacear.prjintegrador5.model.business.AutorBusiness;
import br.edu.unifacear.prjintegrador5.model.business.BusinessException;
import br.edu.unifacear.prjintegrador5.model.entity.Autor;

public class AutorTeste {

	public static void main(String[] args) throws BusinessException {
		AutorBusiness business = new AutorBusiness();
		
		/*for(Autor a: dao.obter("m")) {
			System.out.println("Id: " + a.getId() + " Nome:" + a.getNome() + " Editais: " 
		+ a.getQuantEditais());
		}*/
		
		//dao.excluir(new Autor(3, "", 0));
		
		business.inserir(new Autor(0, "teste", 5));

	}

}
