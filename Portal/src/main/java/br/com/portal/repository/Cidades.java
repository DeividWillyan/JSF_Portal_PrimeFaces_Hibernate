package br.com.portal.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.portal.model.Cidade;
import br.com.portal.util.HibernateUtil;

public class Cidades {

	public void salvar(Cidade cidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(cidade);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}

	}

	public void excluir(Long codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Cidade cidade = null;

		try {
			cidade = buscarPorCodigo(codigo);
			transaction = session.beginTransaction();
			session.delete(cidade);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}

	}

	public void editar(Cidade cidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(cidade);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}

	}

	public Cidade buscarPorCodigo(Long codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Cidade cidade = null;

		try {
			cidade = (Cidade) session.createQuery("FROM cidade WHERE id = " + codigo).getSingleResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return cidade;
	}

	public List<Cidade> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Cidade> itens = null;

		try {
			itens = session.createQuery("FROM cidade", Cidade.class).list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return itens;
	}

}
