package br.com.portal.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.portal.model.Pessoa;
import br.com.portal.util.HibernateUtil;

public class Pessoas {

	public void salvar(Pessoa pessoa) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(pessoa);
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
		Pessoa pessoa = null;

		try {
			pessoa = buscarPorCodigo(codigo);
			transaction = session.beginTransaction();
			session.delete(pessoa);
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

	public void editar(Pessoa pessoa) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(pessoa);
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

	public Pessoa buscarPorCodigo(Long codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Pessoa pessoa = null;

		try {
			pessoa = (Pessoa) session.createQuery("FROM pessoa WHERE id = " + codigo).getSingleResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return pessoa;
	}

	public List<Pessoa> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Pessoa> itens = null;

		try {
			itens = session.createQuery("FROM pessoa", Pessoa.class).list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return itens;
	}

}
