package rest.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double nota;
	private int frequencia;
	private int codigoDisciplina;
	private int codigoAluno;
	private ArrayList<Nota> listaNotas = new ArrayList<Nota>();
	
	public Nota() {}

	public Nota(Double nota, int frequencia, int codigoDisciplina, int codigoAluno) {
		super();
		this.nota = nota;
		this.frequencia = frequencia;
		this.codigoDisciplina = codigoDisciplina;
		this.codigoAluno = codigoAluno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public int getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public ArrayList<Nota> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(ArrayList<Nota> listaNotas) {
		this.listaNotas = listaNotas;
	}
	
}
