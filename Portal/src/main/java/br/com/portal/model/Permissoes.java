package br.com.portal.model;

public enum Permissoes {

	USUARIO("Usuario", 1), 
	SUPERVISOR("Supervisor", 2), 
	GERENTE("Gerente", 3), 
	ADMINISTRADOR("Administrador", 4);

	private final String permissao;
	private final Integer level;

	private Permissoes(String permissao, Integer level) {
		this.permissao = permissao;
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

	public String getPermissao() {
		return permissao;
	}

}
