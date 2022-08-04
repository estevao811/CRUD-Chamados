package model;


public class Usuario {

	private int idUsuario;
	private String nome;
	private String email;
	private String login;
	private String senha;
	
	public Usuario(int idUsuario, String nome, String email, String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

	public Usuario() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
