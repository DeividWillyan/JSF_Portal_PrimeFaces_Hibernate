package br.com.portal.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.portal.model.Usuario;
import br.com.portal.util.HibernateUtil;

public class Usuarios {

	public void salvar(Usuario usuario) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(usuario);
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
		Usuario usuario = null;

		try {
			usuario = buscarPorCodigo(codigo);
			transaction = session.beginTransaction();
			session.delete(usuario);
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

	public void editar(Usuario usuario) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(usuario);
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

	public Usuario buscarPorCodigo(Long codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			usuario = (Usuario) session.createQuery("FROM usuario WHERE id = " + codigo).getSingleResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return usuario;
	}

	public List<Usuario> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> itens = null;

		try {
			itens = session.createQuery("FROM usuario", Usuario.class).list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return itens;
	}

}
