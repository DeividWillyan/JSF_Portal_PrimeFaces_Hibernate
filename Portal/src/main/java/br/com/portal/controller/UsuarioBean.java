package br.com.portal.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.portal.model.Usuario;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario;
	private List<Usuario> usuarios;

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
	}

	public void salvar() {
	}

	public void editar() {
	}

	public void deletar() {
	}

}
