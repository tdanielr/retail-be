package academia.proyecto.retailacademiaapi.services;

import java.util.List;

import academia.proyecto.retailacademiaapi.dto.ProveedorDTO;

public interface ProveedorService {

	public ProveedorDTO crearProveedor(ProveedorDTO proveedorDto);
	
	public List<ProveedorDTO> getAllProveedores();
	
	public ProveedorDTO getProveedorById(int id);
	
}
