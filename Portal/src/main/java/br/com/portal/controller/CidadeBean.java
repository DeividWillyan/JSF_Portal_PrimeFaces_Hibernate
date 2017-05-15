package br.com.portal.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.portal.model.Cidade;
import br.com.portal.model.Estado;
import br.com.portal.repository.Cidades;
import br.com.portal.repository.Estados;
import br.com.portal.util.FacesUtil;

@ManagedBean
public class CidadeBean {

	private Cidade cidade;
	private List<Cidade> cidades;
	private Estado estado;
	private List<Estado> estados;

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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void novo() {
		cidade = new Cidade();
		cidades = new Cidades().listar();
		estados = new Estados().listar();
	}

	public void salvar() {
		try {
			Cidades dao = new Cidades();
			dao.salvar(cidade);

			novo();

			FacesUtil.msgSucesso("Cidade salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgErro("Erro ao salvar a Cidade.");
			ex.printStackTrace();
		}
	}

	public void editar() {
		try {
			Cidades dao = new Cidades();
			dao.editar(cidade);

			novo();

			FacesUtil.msgSucesso("Cidade editada com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgErro("Erro ao editar cidade.");
			ex.printStackTrace();
		}

	}

	public void deletar() {
		try {
			Cidades dao = new Cidades();
			dao.excluir(cidade.getIdCidade());

			novo();

			FacesUtil.msgSucesso("Cidade exluida com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.msgErro("Erro ao excluir a cidade.");
			ex.printStackTrace();
		}

	}

}
