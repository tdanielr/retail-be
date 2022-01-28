package academia.proyecto.retailacademiaapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academia.proyecto.retailacademiaapi.dto.ProductoDTO;
import academia.proyecto.retailacademiaapi.dto.RespuestaPaginaProducto;
import academia.proyecto.retailacademiaapi.services.ProductoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoServicio;
	
	@PostMapping(produces="application/json")
	public  ResponseEntity<ProductoDTO> createProducto(@Valid @RequestBody ProductoDTO productoDto){
		
		return new ResponseEntity<ProductoDTO>(productoServicio.crearProducto(productoDto.getCategoriaId(), productoDto.getProveedorId(), productoDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public RespuestaPaginaProducto getAll(
			@RequestParam(value="numeroPagina", defaultValue = "0", required = false) int numeroPagina,
			@RequestParam(value = "tamañoPagina",  defaultValue = "8" ,required = false) int tamañoPagina) {
		return productoServicio.getAllProductos(numeroPagina, tamañoPagina);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> getProductoById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<ProductoDTO>(productoServicio.getProductoById(id), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces =" application/json")
	public ResponseEntity<String> deleteProducto(@PathVariable(name = "id") int id) {
		productoServicio.deleteProducto(id);
		return new ResponseEntity<String>("Eliminado correctamente", HttpStatus.OK);
	}


	@PutMapping("/{id}")
	public ResponseEntity<ProductoDTO> updateProducto(@Valid @RequestBody ProductoDTO productoDto,
			@PathVariable(name = "id") int id) {
		ProductoDTO productoDtoNuevo = productoServicio.updateProducto(productoDto, id);
		return new ResponseEntity<ProductoDTO>(productoDtoNuevo, HttpStatus.OK);
	}

	
}
