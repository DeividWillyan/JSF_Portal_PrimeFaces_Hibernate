package br.com.portal.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.portal.model.Cidade;
import br.com.portal.model.Estado;
import br.com.portal.repository.Cidades;

@ManagedBean
public class CidadeBean {

	private Cidade cidade;
	private List<Cidade> cidades;
	private Estado estado;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@PostConstruct
	public void novo() {
		cidade = new Cidade();
		cidades = new Cidades().listar();
	}

	public void salvar() {

	}

	public void editar() {

	}

	public void deletar() {

	}

}
