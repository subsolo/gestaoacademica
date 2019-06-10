package rest.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Disciplina implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	
	public Disciplina() {}

	public Disciplina(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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

	public ArrayList<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(ArrayList<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}
	
}
