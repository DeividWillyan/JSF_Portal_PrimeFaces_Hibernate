package br.com.portal.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.portal.model.Estado;
import br.com.portal.repository.Estados;

@ManagedBean
public class EstadoBean {

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void novo() {
		Estados e = new Estados();
		estados = e.listar();
		estado = new Estado();
	}

	public void salvar() {
		try {
			Estados dao = new Estados();
			dao.salvar(estado);

			novo();

			System.out.println("Estado salvo com sucesso!");
		} catch (RuntimeException ex) {
			System.out.println("Erro ao salvar estado.");
			ex.printStackTrace();
		}
	}

	public void editar() {
		try {
			Estados dao = new Estados();
			dao.editar(estado);

			novo();

			System.out.println("Estado Editado com sucesso!");
		} catch (RuntimeException ex) {
			System.out.println("Erro ao Editar estado.");
			ex.printStackTrace();
		}
	}

	public void deletar() {
		try {
			Estados dao = new Estados();
			dao.excluir(estado.getIdEstado());

			novo();

			System.out.println("Estado Excluido com sucesso!");
		} catch (RuntimeException ex) {
			System.out.println("Erro ao Excluir o estado.");
			ex.printStackTrace();
		}
	}

}
