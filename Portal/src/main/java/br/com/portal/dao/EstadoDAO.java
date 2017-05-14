package br.com.portal.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.portal.model.Estado;
import br.com.portal.util.HibernateUtil;

public class EstadoDAO {

	public void salvar(Estado estado) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(estado);
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
		Estado estado = null;

		try {
			estado = buscarPorCodigo(codigo);
			transaction = session.beginTransaction();
			session.delete(estado);
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

	public void editar(Estado estado) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(estado);
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

	public Estado buscarPorCodigo(Long codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Estado estado = null;

		try {
			estado = (Estado) session.createQuery("FROM estado WHERE id = " + codigo).getSingleResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return estado;
	}

	public List<Estado> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Estado> itens = null;

		try {
			itens = session.createQuery("FROM estado", Estado.class).list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return itens;
	}

}
