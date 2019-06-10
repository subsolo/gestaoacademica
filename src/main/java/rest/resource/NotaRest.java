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

import rest.api.NotaApi;
import rest.model.Nota;

@Path("nota")
public class NotaRest {
	
	private static Nota nota;
	
	public NotaRest() {
		if(nota == null)
			nota = new Nota();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar-notas")
	public List<NotaApi> listarNotas() {
		return NotaApi.converterParaListaApi(nota.getListaNotas());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pesquisar-por-codigo/{codigoAluno}/{codigoDisciplina}")
	public NotaApi pesquisarNotaPorAlunoEDisciplina(@PathParam("codigoAluno") int codigoAluno, 
			@PathParam("codigoDisciplina") int codigoDisciplina) {
		List<Nota> lista = nota.getListaNotas();
		for (Nota n : lista) {
			if (n.getCodigoAluno() == codigoAluno && n.getCodigoDisciplina() == codigoDisciplina)
				return NotaApi.converterParaApi(n);
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public NotaApi persistirNota(NotaApi api) {
		nota.setCodigoAluno(api.getCodigoAluno());
		nota.setCodigoDisciplina(api.getCodigoDisciplina());
		nota.setFrequencia(api.getFrequencia());
		nota.setNota(api.getNota());
		
		return NotaApi.converterParaApi(nota);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{codigoAluno}/{codigoDisciplina}")
	public NotaApi editarNota(@PathParam("codigoAluno") int codigoAluno, 
			@PathParam("codigoDisciplina") int codigoDisciplina, NotaApi api) {
		List<Nota> lista = nota.getListaNotas();
		for (Nota n : lista) {
			if (n.getCodigoAluno() == codigoAluno && n.getCodigoDisciplina() == codigoDisciplina){
				n.setCodigoAluno(api.getCodigoAluno());
				n.setCodigoDisciplina(api.getCodigoDisciplina());
				n.setFrequencia(api.getFrequencia());
				n.setNota(api.getNota());
				return NotaApi.converterParaApi(n);
			}
		}
		return null;
	}
	
	@DELETE
	@Path("/{codigoAluno}/{codigoDisciplina}")
	public Response removerNota(@PathParam("codigoAluno") int codigoAluno, 
			@PathParam("codigoDisciplina") int codigoDisciplina) {
		List<Nota> lista = nota.getListaNotas();
		for (Nota n : lista) {
			if (n.getCodigoAluno() == codigoAluno && n.getCodigoDisciplina() == codigoDisciplina)
				lista.remove(n);
				return Response.ok().build();
		}
		return Response.notModified().build();
	}
}
