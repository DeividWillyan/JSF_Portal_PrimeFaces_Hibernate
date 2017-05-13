package br.com.portal.model;

public class PermissoesTest {

	public static void main(String[] args) {

		Permissoes permissoes = Permissoes.USUARIO;
		System.out.println(permissoes.getLevel());
		System.out.println(permissoes.getPermissao());

	}

}
