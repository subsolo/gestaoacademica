package rest.api;

import java.util.ArrayList;
import java.util.List;

import rest.model.Aluno;

public class AlunoApi {
	private int codigo;
	private String nome;
	private String email;
	
	public static AlunoApi converterParaApi(Aluno aluno) {
		if (aluno == null)
			return null;
		AlunoApi api = new AlunoApi();
		api.setCodigo(aluno.getCodigo());
		api.setNome(aluno.getNome());
		api.setEmail(aluno.getEmail());
		return api;
	}
	
	public static List<AlunoApi> converterParaListaApi(ArrayList<Aluno> listaAlunos) {
		List<AlunoApi> lista = new ArrayList<AlunoApi>();
		for(Aluno aluno : listaAlunos) {
			lista.add(converterParaApi(aluno));
		}
		return lista;
	}
	
	public static ArrayList<AlunoApi> converterListaApi(ArrayList<Aluno> listaApi) {
		ArrayList<AlunoApi> lista = new ArrayList<AlunoApi>();
		for(Aluno aluno : listaApi) {
			lista.add(converterParaApi(aluno));
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
