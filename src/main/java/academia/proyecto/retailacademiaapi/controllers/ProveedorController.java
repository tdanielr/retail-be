package academia.proyecto.retailacademiaapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academia.proyecto.retailacademiaapi.dto.ProveedorDTO;
import academia.proyecto.retailacademiaapi.services.ProveedorService;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorServicio;
	
	@PostMapping
	public ResponseEntity<ProveedorDTO> createProveedor(@RequestBody ProveedorDTO proveedorDto) {
		return new ResponseEntity<ProveedorDTO>(proveedorServicio.crearProveedor(proveedorDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<ProveedorDTO> getAllProveedores(){
		return proveedorServicio.getAllProveedores();
	}
	
}
