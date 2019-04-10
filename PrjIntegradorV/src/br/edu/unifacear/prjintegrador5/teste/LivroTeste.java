package br.edu.unifacear.prjintegrador5.teste;

import br.edu.unifacear.prjintegrador5.model.dao.LivroDAO;
import br.edu.unifacear.prjintegrador5.model.entity.Autor;
import br.edu.unifacear.prjintegrador5.model.entity.Editora;
import br.edu.unifacear.prjintegrador5.model.entity.Livro;

public class LivroTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Autor a = new Autor();
//		a.setId(1);
////		Editora e = new Editora();
////		e.setId(4);
////		Livro l = new Livro(7, "Com a morte na alma", a, e, "O livro retrata a angústia e o sentimento de resistência do povo francês perante a ocupação alemã no inicio da Segunda Guerra Mundial");
////		
////		new LivroDAO().alterar(l);
//		
//		for(Livro l : new LivroDAO().obter(a)) {
//			System.out.println("Livro: " + l.getTitulo() + " | Autor: " + l.getAutor().getNome() + " | Editora: " + l.getEditora().getRazaoSocial());
//		}
		
		Livro l = new Livro();
		
		l.setId(1000);
		
		new LivroDAO().excluir(l);
	}

}
