package rest.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private String email;
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	
	public Aluno() {}
	
	public Aluno(int codigo, String nome, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public ArrayList<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	
	
}
