package br.com.portal.dao;

import br.com.portal.model.Estado;
import br.com.portal.util.HibernateUtil;

public class EstadoDAOTest {

	public static void main(String[] args) {

		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
	
		EstadoDAO dao = new EstadoDAO();
		dao.salvar(estado);
		
		for(Estado e : dao.listar()) {
			System.out.println(e.getNome());
		}
		
		HibernateUtil.shutdown();
		
	}

}
