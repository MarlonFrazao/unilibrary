package br.edu.unifacear.prjintegrador5.teste;

import br.edu.unifacear.prjintegrador5.model.business.BusinessException;
import br.edu.unifacear.prjintegrador5.model.business.PermissaoBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Permissao;

public class PermissaoTeste {

	public static void main(String[] args) throws BusinessException {
		// TODO Auto-generated method stub
		Permissao p = new Permissao(5, "Tremendão");
		
		new PermissaoBusiness().alterar(p);
		
		
	}

}
