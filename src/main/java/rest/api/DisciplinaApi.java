package rest.api;

import java.util.ArrayList;
import java.util.List;

import rest.model.Disciplina;

public class DisciplinaApi {
	private int codigo;
	private String nome;
	
	public static DisciplinaApi converterParaApi(Disciplina disciplina) {
		if (disciplina == null)
			return null;
		DisciplinaApi api = new DisciplinaApi();
		api.setCodigo(disciplina.getCodigo());
		api.setNome(disciplina.getNome());
		return api;
	}
	
	public static List<DisciplinaApi> converterParaListaApi(ArrayList<Disciplina> listaDisciplinas){
		List<DisciplinaApi> lista = new ArrayList<DisciplinaApi>();
		for (Disciplina disciplina : listaDisciplinas) {
			lista.add(converterParaApi(disciplina));
		}
		return lista;
	}
	
	public static ArrayList<DisciplinaApi> converterListaApi(ArrayList<Disciplina> listaDisciplinas){
		ArrayList<DisciplinaApi> lista = new ArrayList<DisciplinaApi>();
		for (Disciplina api : listaDisciplinas) {
			lista.add(converterParaApi(api));
		}
		return lista;
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
	
	
}
