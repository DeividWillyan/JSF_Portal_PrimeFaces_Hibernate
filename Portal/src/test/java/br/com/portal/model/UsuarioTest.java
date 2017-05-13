package br.com.portal.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UsuarioTest {

	public static void main(String[] args) {

		Estado estado = new Estado();
		Cidade cidade = new Cidade();
		Pessoa pessoa = new Pessoa();
		Usuario usuario = new Usuario();

		estado.setIdEstado(1L);
		estado.setNome("Parana");
		estado.setSigla("PR");

		cidade.setIdCidade(2L);
		cidade.setNome("Londrina");
		cidade.setEstado(estado);

		pessoa.setIdPessoa(45L);
		pessoa.setNome("Deivid");
		pessoa.setSobreNome("Willyan");
		pessoa.setEmail("deiviid_@hotmail.com");
		pessoa.setDtNasc(new GregorianCalendar(1996, 07, 11));
		pessoa.setCpf("097.580.939-80");
		pessoa.setCelular("(43) 99617-3557");
		pessoa.setTelefone("(43) 3321-0147");
		pessoa.setEstado(estado);
		pessoa.setCidade(cidade);
		pessoa.setEndereco("Rua Jose das neves, 80");

		usuario.setIdUsuario(28L);
		usuario.setPessoa(pessoa);
		usuario.setUsuario("UserDeivid");
		usuario.setPassword("s3nh4_d01d4");
		usuario.setDtCriacao(new GregorianCalendar(2017, 05, 13));
		usuario.setPermissoes(Permissoes.ADMINISTRADOR);

		System.out.println("Nome: " + usuario.getPessoa().getNome());
		System.out.println("Usuario: " + usuario.getUsuario());
		System.out.println("Senha: " + usuario.getPassword());
		System.out.println("Data criacao: " + usuario.getDtCriacao());
		System.out.println("Cidade: " + usuario.getPessoa().getCidade().getNome());
		System.out.println("Estado: " + usuario.getPessoa().getCidade().getEstado().getNome());
		System.out.println("Sigle Estado: " + usuario.getPessoa().getCidade().getEstado().getSigla());
		System.out.println("Celular: " + usuario.getPessoa().getCelular());
		System.out.println("Permissao: " + usuario.getPermissoes().getPermissao());
		System.out.println("Lever Permissao: " + usuario.getPermissoes().getLevel());

	}

}
