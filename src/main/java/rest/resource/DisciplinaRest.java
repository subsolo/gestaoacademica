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

import rest.api.DisciplinaApi;
import rest.model.Disciplina;

@Path("disciplina")
public class DisciplinaRest {
	
	private static Disciplina disciplina;
	
	public DisciplinaRest() {
		if (disciplina == null)
			disciplina = new Disciplina();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar-disciplinas")
	public List<DisciplinaApi> listarDisciplinas() {
		return DisciplinaApi.converterParaListaApi(disciplina.getListaDisciplina());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pesquisar-por-codigo/{codigo}")
	public DisciplinaApi pesquisarDisciplinaPorCodigo(@PathParam("codigo") int codigo) {
		List<Disciplina> lista = disciplina.getListaDisciplina();
		for (Disciplina d : lista) {
			if(disciplina.getCodigo() == codigo)
				return DisciplinaApi.converterParaApi(d);
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public DisciplinaApi persistirDisciplina(DisciplinaApi api) {
		disciplina.setNome(api.getNome());
		disciplina.getListaDisciplina().add(disciplina);
		
		return DisciplinaApi.converterParaApi(disciplina);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{codigo}")
	public DisciplinaApi editarDisciplina(@PathParam("codigo") int codigo, DisciplinaApi api) {
		List<Disciplina> lista = disciplina.getListaDisciplina();
		for (Disciplina d : lista) {
			if(disciplina.getCodigo() == codigo) {
				d.setCodigo(api.getCodigo());
				d.setNome(api.getNome());
				return DisciplinaApi.converterParaApi(d);
			}
				
		}
		return null;
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response removerDisciplina(@PathParam("codigo") int codigo) {
		List<Disciplina> lista = disciplina.getListaDisciplina();
		for (Disciplina d : lista) {
			if(disciplina.getCodigo() == codigo)
				lista.remove(d);
			return Response.ok().build();
		}
		return Response.notModified().build();
	}
}
