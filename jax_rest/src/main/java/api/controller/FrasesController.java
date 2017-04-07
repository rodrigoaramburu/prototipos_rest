package api.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import api.model.Frase;
import api.model.RepositorioFrase;

@Path("/frases")
public class FrasesController {
	
	
	@POST
	@Path("/")
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Response adicionar(Frase frase){
		
		RepositorioFrase repo = new RepositorioFrase();
		
		repo.save( frase );

		URI uri = URI.create( "/frases/"+frase.getId() );
		
		return Response.status( 201 ).location( uri).build();
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Response alterar(@PathParam("id") Long id ,  Frase frase){
		
		RepositorioFrase repo = new RepositorioFrase();
		
		Frase f = repo.buscarPorId( id );
		if( f == null ){
			throw new NotFoundException("Frase com id ("+id+") não encontrada");
		}else{
			repo.update( frase );
			return Response.status( 200 ).entity(frase).build();
		}
		
		
	}
		
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Response view(@PathParam("id") Long id){
		
		RepositorioFrase repo = new RepositorioFrase();
		
		Frase frase = repo.buscarPorId(id);
		if( frase != null ){
			return Response.ok().entity(frase).build();
		}else{
			throw new NotFoundException("Frase com id ("+id+") não encontrada");
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id){
		
		RepositorioFrase repo = new RepositorioFrase();
		
		repo.delete(id);
		
		return Response.ok().build();
		
	}
	
	@GET
	@Path("/")
	@Produces( { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML } )
	public Response listar(){
		
		RepositorioFrase repo = new RepositorioFrase();
		
		List<Frase> frases = repo.getFrases();
		
		GenericEntity<List<Frase>> entityFrases = new GenericEntity< List< Frase > >( frases ) { };
		
		return Response.ok().entity(entityFrases).build();
		
	}	
	
	
}
