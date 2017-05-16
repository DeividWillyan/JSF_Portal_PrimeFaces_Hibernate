package br.com.portal.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.portal.model.Cidade;
import br.com.portal.model.Estado;
import br.com.portal.model.Pessoa;
import br.com.portal.repository.Cidades;
import br.com.portal.repository.Estados;
import br.com.portal.repository.Pessoas;
import br.com.portal.util.FacesUtil;

@ManagedBean
public class PessoaBean {

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Estado> estados;
	private List<Cidade> cidades;

	public List<Cidade> getCidades() {
		return cidades = new Cidades().listar();
	}

	public List<Estado> getEstados() {
		return estados = new Estados().listar();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void novo() {

		pessoa = new Pessoa();
		pessoas = new Pessoas().listar();

	}

	public void salver() {

		try {
			Pessoas dao = new Pessoas();
			dao.salvar(pessoa);

			novo();

			FacesUtil.msgSucesso("Pessoa salva com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.msgErro("Erro ao salver a pessoa");
			e.printStackTrace();
		}

	}

	public void deletar() {

		try {
			Pessoas dao = new Pessoas();
			dao.excluir(pessoa.getIdPessoa());

			novo();

			FacesUtil.msgSucesso("Pessoa excluida com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.msgErro("Erro ao excluir a pessoa");
			e.printStackTrace();
		}

	}

	public void editar() {

		try {
			Pessoas dao = new Pessoas();
			dao.editar(pessoa);

			novo();

			FacesUtil.msgSucesso("Pessoa editada com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.msgErro("Erro ao editar a pessoa");
			e.printStackTrace();
		}

	}

}
