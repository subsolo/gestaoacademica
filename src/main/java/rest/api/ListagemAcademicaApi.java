package rest.api;

import java.util.ArrayList;

import rest.model.Aluno;
import rest.model.Disciplina;
import rest.model.Nota;

public class ListagemAcademicaApi {
	private String nome;
	private ArrayList<NotaApi> notaApi;
	private ArrayList<DisciplinaApi> disciplinaApi;
	private ArrayList<AlunoApi> alunoApi;

	public static ListagemAcademicaApi converterParaApi(String nome, ArrayList<Nota> nota,
			ArrayList<Disciplina> disciplina,ArrayList<Aluno> aluno) {
		ListagemAcademicaApi api = new ListagemAcademicaApi();
		api.setNome(nome);
		api.setAlunoApi(AlunoApi.converterListaApi(aluno));
		api.setDisciplinaApi(DisciplinaApi.converterListaApi(disciplina));
		api.setNotaApi(NotaApi.converterListaApi(nota));
		return api;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<NotaApi> getNotaApi() {
		return notaApi;
	}
	public void setNotaApi(ArrayList<NotaApi> notaApi) {
		this.notaApi = notaApi;
	}
	public ArrayList<DisciplinaApi> getDisciplinaApi() {
		return disciplinaApi;
	}
	public void setDisciplinaApi(ArrayList<DisciplinaApi> disciplinaApi) {
		this.disciplinaApi = disciplinaApi;
	}
	public ArrayList<AlunoApi> getAlunoApi() {
		return alunoApi;
	}
	public void setAlunoApi(ArrayList<AlunoApi> alunoApi) {
		this.alunoApi = alunoApi;
	}
	
	
}
