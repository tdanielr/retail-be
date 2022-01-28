package academia.proyecto.retailacademiaapi.mapeos;

import academia.proyecto.retailacademiaapi.dto.ProveedorDTO;
import academia.proyecto.retailacademiaapi.entities.Proveedor;

public class MapeoProveedor {


	// convierte una entidad a dto
	public static ProveedorDTO convertirADto(Proveedor proveedor) {

		ProveedorDTO proveedorDTO = new ProveedorDTO();

		proveedorDTO.setId(proveedor.getId());
		proveedorDTO.setNombre(proveedor.getNombre());
		proveedorDTO.setDireccion(proveedor.getDirrecion());
		proveedorDTO.setCuit(proveedor.getCuit());
		
		return proveedorDTO;

	}

	// convierte un dto a una entidad
	public static Proveedor convertirAProveedor(ProveedorDTO proveedorDto) {

		Proveedor proveedor = new Proveedor();
		proveedor.setId(proveedorDto.getId());
		proveedor.setNombre(proveedorDto.getNombre());
		proveedor.setDirrecion(proveedorDto.getDireccion());
		proveedor.setCuit(proveedorDto.getCuit());
		
		return proveedor;

	}

	
	
}
