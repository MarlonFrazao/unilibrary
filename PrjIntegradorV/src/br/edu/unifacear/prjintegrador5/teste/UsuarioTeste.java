package br.edu.unifacear.prjintegrador5.teste;

import br.edu.unifacear.prjintegrador5.model.business.AlunoBusiness;
import br.edu.unifacear.prjintegrador5.model.business.BusinessException;
import br.edu.unifacear.prjintegrador5.model.business.UsuarioBusiness;
import br.edu.unifacear.prjintegrador5.model.entity.Permissao;
import br.edu.unifacear.prjintegrador5.model.entity.Usuario;

public class UsuarioTeste {
	
	public static void main(String[] args) throws BusinessException {
		
		UsuarioBusiness business = new UsuarioBusiness();
		
		business.inserir(new Usuario(0, 13, 123, new Permissao(1, "teste"), true, 
				new AlunoBusiness().obterPorId(1)));
	}
}
