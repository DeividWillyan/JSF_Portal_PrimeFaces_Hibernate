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
		Estado estado = null;
		return estado;
	}

	public List<Estado> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Estado> itens = null;

		try {
			Query query = session.createQuery("FROM estado");
			itens = query.getResultList();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return itens;
	}

}
