package rest.api;

import java.util.ArrayList;
import java.util.List;

import rest.model.Nota;

public class NotaApi {
	private Double nota;
	private int frequencia;
	private int codigoDisciplina;
	private int codigoAluno;
	
	public static NotaApi converterParaApi(Nota nota) {
		if (nota == null)
			return null;
		NotaApi api = new NotaApi();
		api.setCodigoAluno(nota.getCodigoAluno());
		api.setCodigoDisciplina(nota.getCodigoDisciplina());
		api.setFrequencia(nota.getFrequencia());
		api.setNota(nota.getNota());
		
		return api;
	}
	
	public static List<NotaApi> converterParaListaApi(ArrayList<Nota> listaNotas){
		List<NotaApi> lista = new ArrayList<NotaApi>();
		for (Nota nota : listaNotas) {
			lista.add(converterParaApi(nota));
		}
		return lista;
	}
	
	public static ArrayList<NotaApi> converterListaApi(ArrayList<Nota> listaNotas){
		ArrayList<NotaApi> lista = new ArrayList<NotaApi>();
		for (Nota notaApi : listaNotas) {
			lista.add(converterParaApi(notaApi));
		}
		return lista;
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
}
