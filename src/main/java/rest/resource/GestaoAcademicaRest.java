package rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.api.ListagemAcademicaApi;
import rest.model.Aluno;
import rest.model.Disciplina;
import rest.model.Nota;


@Path("api")
public class GestaoAcademicaRest {

	private static Nota nota;
	private static Disciplina disciplina;
	private static Aluno aluno;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar-geral")
	public ListagemAcademicaApi listarGeral() {
		
		return ListagemAcademicaApi.converterParaApi("geral",
				nota.getListaNotas(), disciplina.getListaDisciplina(), aluno.getListaAlunos());
	}
}
