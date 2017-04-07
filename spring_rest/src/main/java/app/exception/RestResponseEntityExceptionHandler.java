package app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { ResourceNotFoundException.class })
    protected ResponseEntity<?> handleConflict(ResourceNotFoundException ex) {
    	Map<String,String> map = new HashMap<String,String>();
		map.put("statusCode" , "404");
		map.put("mensagem", ex.getMessage());

		return ResponseEntity.status( 404 ).body( map );
    }
}
