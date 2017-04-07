package api.exception;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import api.model.Erro;

@Provider
public class EntityNotFound implements ExceptionMapper<NotFoundException> {
	 
	public Response toResponse(NotFoundException exception) {
			
		Erro responseEntity = new Erro(404 , exception.getMessage() );
			
 		return Response.status(404).
				      entity(responseEntity).
				     // type("application/json").
				      build();
		}
}