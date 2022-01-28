package academia.proyecto.retailacademiaapi.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNotFoundExcepcion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String recurso;
	private String atributo;

	public RecursoNotFoundExcepcion(String recurso, String atributo) {
		super("No encontrado: " + recurso + " - " + atributo);
		this.recurso = recurso;
		this.atributo = atributo;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

}
