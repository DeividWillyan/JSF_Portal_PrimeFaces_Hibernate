package br.com.portal.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.portal.model.Permissoes;
import br.com.portal.model.Pessoa;
import br.com.portal.model.Usuario;
import br.com.portal.repository.Pessoas;
import br.com.portal.repository.Usuarios;
import br.com.portal.util.FacesUtil;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Pessoa> pessoas;
	private Permissoes[] permissoes;

	public Permissoes[] getPermissoes() {
		return permissoes = Permissoes.values();
	}

	public List<Pessoa> getPessoas() {
		return pessoas = new Pessoas().listar();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@PostConstruct
	public void novo() {
		usuario = new Usuario();
		listaUsuarios();
	}
	
	public void listaUsuarios() {
		try {
			Usuarios dao = new Usuarios();
			usuarios = dao.listar();
			
		} catch (RuntimeException e) {
			FacesUtil.msgErro("Erro ao listar os usuarios");
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			Usuarios dao = new Usuarios();
			dao.salvar(usuario);

			novo();

			FacesUtil.msgSucesso("Usuario salvo com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.msgErro("Erro ao salver o usuario");
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			Usuarios dao = new Usuarios();
			dao.editar(usuario);

			novo();

			FacesUtil.msgSucesso("Usuario editado com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.msgErro("Erro ao editar o usuario");
			e.printStackTrace();
		}
	}

	public void deletar() {
		try {
			Usuarios dao = new Usuarios();
			dao.excluir(usuario.getIdUsuario());

			novo();

			FacesUtil.msgSucesso("Usuario excluido com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.msgErro("Erro ao excluir o usuario");
			e.printStackTrace();
		}
	}

}
