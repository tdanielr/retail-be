package academia.proyecto.retailacademiaapi.excepciones;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ManejadorExcepciones extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errores = new HashMap<>();

		// obtengo los errores y los recorro uno por uno
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String nombreAtributoError = ((FieldError) error).getField();
			String mensaje = error.getDefaultMessage();
			errores.put(nombreAtributoError, mensaje);
		});

		return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
	}

}
