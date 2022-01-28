package academia.proyecto.retailacademiaapi.bo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academia.proyecto.retailacademiaapi.daos.ProveedorDao;
import academia.proyecto.retailacademiaapi.dto.ProveedorDTO;
import academia.proyecto.retailacademiaapi.entities.Proveedor;
import academia.proyecto.retailacademiaapi.excepciones.RecursoNotFoundExcepcion;
import academia.proyecto.retailacademiaapi.mapeos.MapeoProveedor;
import academia.proyecto.retailacademiaapi.services.ProveedorService;

@Service
public class ProveedorBo implements ProveedorService {

	@Autowired
	private ProveedorDao proveedorDao;

	@Override
	public ProveedorDTO crearProveedor(ProveedorDTO proveedorDto) {

		// pasamos el dao a entidad
		Proveedor proveedor = MapeoProveedor.convertirAProveedor(proveedorDto);

		// persistimos la entidad
		Proveedor ProveedorNuevo = proveedorDao.save(proveedor);

		// devuelvo el dto
		ProveedorDTO proveedorNuevoDto = MapeoProveedor.convertirADto(ProveedorNuevo);
		return proveedorNuevoDto;
	}

	@Override
	public List<ProveedorDTO> getAllProveedores() {

		List<Proveedor> listaProveedores = proveedorDao.findAll();

		List<ProveedorDTO> listaProveedorDto = listaProveedores.stream().map(prov -> MapeoProveedor.convertirADto(prov))
				.collect(Collectors.toList());

		return listaProveedorDto;
	}

	@Override
	public ProveedorDTO getProveedorById(int id) {

		Proveedor proveedor = proveedorDao.findById(id)
				.orElseThrow(() -> new RecursoNotFoundExcepcion("Proveedor", "id"));

		ProveedorDTO proveedorDto = MapeoProveedor.convertirADto(proveedor);

		return proveedorDto;

	}

}
