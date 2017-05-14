package br.com.portal.main;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.portal.model.Cidade;
import br.com.portal.model.Estado;
import br.com.portal.model.Permissoes;
import br.com.portal.model.Pessoa;
import br.com.portal.model.Usuario;
import br.com.portal.util.HibernateUtil;

public class create {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		Estado estado = new Estado();
		Cidade cidade = new Cidade();
		Pessoa pessoa = new Pessoa();
		Usuario usuario = new Usuario();

		estado.setIdEstado(1L);
		estado.setNome("Parana");
		estado.setSigla("PR");

		cidade.setIdCidade(2L);
		cidade.setNome("Londrina");
		cidade.setEstado(estado);

		pessoa.setIdPessoa(45L);
		pessoa.setNome("Deivid");
		pessoa.setSobreNome("Willyan");
		pessoa.setEmail("deiviid_@hotmail.com");
		pessoa.setDtNasc(new GregorianCalendar(1996, 07, 11));
		pessoa.setCpf("097.580.939-80");
		pessoa.setCelular("(43) 99617-3557");
		pessoa.setTelefone("(43) 3321-0147");
		pessoa.setEstado(estado);
		pessoa.setCidade(cidade);
		pessoa.setEndereco("Rua Jose das neves, 80");

		usuario.setIdUsuario(28L);
		usuario.setPessoa(pessoa);
		usuario.setUsuario("UserDeivid");
		usuario.setPassword("s3nh4_d01d4");
		usuario.setDtCriacao(new GregorianCalendar(2017, 05, 13));
		usuario.setPermissoes(Permissoes.ADMINISTRADOR);

		try {
			transaction = session.beginTransaction();
			session.save(estado);
			session.save(cidade);
			session.save(pessoa);
			session.save(usuario);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}

}
