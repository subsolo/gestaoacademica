package rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.api.AlunoApi;
import rest.model.Aluno;

@Path("aluno")
public class AlunoRest {

	private static Aluno aluno;
	
	public AlunoRest() {
		if (aluno == null)
			aluno = new Aluno();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar-alunos")
	public List<AlunoApi> listarAlunos() {
		return AlunoApi.converterParaListaApi(aluno.getListaAlunos());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pesquisar-por-codigo/{codigo}")
	public AlunoApi pesquisarAlunoPorCodigo(@PathParam("codigo") int codigo) {
		List<Aluno> alunos = aluno.getListaAlunos();
		for(Aluno aluno : alunos) {
			if(aluno.getCodigo() == codigo)
				return AlunoApi.converterParaApi(aluno);
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public AlunoApi persistirAluno(AlunoApi api) {
		aluno.setCodigo(api.getCodigo());
		aluno.setNome(api.getNome());
		aluno.setEmail(api.getEmail());
		aluno.getListaAlunos().add(aluno);
		
		return AlunoApi.converterParaApi(aluno);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{codigo}")
	public AlunoApi editarAluno(@PathParam("codigo") int codigo, AlunoApi api) {
		List<Aluno> alunos = aluno.getListaAlunos();
		for(Aluno aluno : alunos) {
			if(aluno.getCodigo() == codigo)
				aluno.setNome(api.getNome());
				aluno.setEmail(api.getEmail());
				return AlunoApi.converterParaApi(aluno);
		}
		return null;
	
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response removerAluno(@PathParam("codigo") int codigo) {
		List<Aluno> alunos = aluno.getListaAlunos();
		for(Aluno aluno : alunos) {
			if(aluno.getCodigo() == codigo)
				alunos.remove(aluno);
				return Response.ok().build();
		}
		return Response.notModified().build();
	}
}
