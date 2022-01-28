package academia.proyecto.retailacademiaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academia.proyecto.retailacademiaapi.dto.CategoriaDTO;
import academia.proyecto.retailacademiaapi.dto.RespuestaPaginaCategoria;
import academia.proyecto.retailacademiaapi.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaServicio;

	@PostMapping
	public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDto) {
		return new ResponseEntity<>(categoriaServicio.crearCategoria(categoriaDto), HttpStatus.CREATED);
	}

	@GetMapping
	public RespuestaPaginaCategoria getAll(
			@RequestParam(value="numeroPagina", defaultValue = "0", required = false) int numeroPagina,
			@RequestParam(value = "tamañoPagina", defaultValue = "8", required = false) int tamañoPagina) {
		return categoriaServicio.getAllCategorias(numeroPagina, tamañoPagina);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<CategoriaDTO>(categoriaServicio.getCategoriaById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> updateCategoria(@RequestBody CategoriaDTO categoriaDto,
			@PathVariable(name = "id") int id) {
		CategoriaDTO categoriaDtoNueva = categoriaServicio.updateCategoria(categoriaDto, id);
		return new ResponseEntity<CategoriaDTO>(categoriaDtoNueva, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategoria(@PathVariable(name = "id") int id) {
		categoriaServicio.deleteCategoria(id);
		return new ResponseEntity<String>("Eliminado correctamente", HttpStatus.OK);
	}

}
