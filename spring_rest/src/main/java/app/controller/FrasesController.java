package app.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.exception.ResourceNotFoundException;
import app.model.Frase;
import app.model.RepositorioFrase;

@RestController
public class FrasesController {

	@RequestMapping(value="/frases" , method=RequestMethod.POST , consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> adicionar( @RequestBody Frase frase){
		RepositorioFrase repo = new RepositorioFrase();
		repo.save( frase );
		
		URI uri = URI.create( "/frases/"+frase.getId() );
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/frases/{id}" , method=RequestMethod.PUT , consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> alterar(@PathVariable("id") Long id , @RequestBody Frase frase){
		RepositorioFrase repo = new RepositorioFrase();
		
		Frase f = repo.buscarPorId( id );
		if( f == null ){
			throw new ResourceNotFoundException("Frase com id ("+id+") não encontrada");
		}else{
			repo.update( frase );
			return ResponseEntity.ok().body(frase );
		}
	}
	
	@RequestMapping(value="/frases" , method=RequestMethod.GET , produces={MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> listar(){
		
		RepositorioFrase repo = new RepositorioFrase();
		List<Frase> frases = repo.getFrases();
		
		return ResponseEntity.status( HttpStatus.OK ).body( frases );
		
	}
	
	@RequestMapping(value="/frases/{id}" , method=RequestMethod.GET , produces={MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> view(@PathVariable("id") Long id){
		
		RepositorioFrase repo = new RepositorioFrase();
		Frase frase = repo.buscarPorId(id);
		if( frase != null ){
			return ResponseEntity.status( HttpStatus.OK ).body( frase );
		}else{
			throw new ResourceNotFoundException("Frase ("+id+") não encontrada");
		}
		
	}
	
	@RequestMapping(value="/frases/{id}" , method=RequestMethod.DELETE )
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		RepositorioFrase repo = new RepositorioFrase();
		repo.delete( id);
		
		return ResponseEntity.status( HttpStatus.OK ).build();
		
	}
	
}
