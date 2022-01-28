package academia.proyecto.retailacademiaapi.mapeos;

import academia.proyecto.retailacademiaapi.dto.ProductoDTO;
import academia.proyecto.retailacademiaapi.entities.Producto;

public class MapeoProducto {

	
	//convierte una entidad a dto
	public static ProductoDTO convertirADto(Producto producto) {
		ProductoDTO productoDto = new ProductoDTO();
		productoDto.setId(producto.getId());
		productoDto.setNombre(producto.getNombre());
		productoDto.setStock(producto.getStock());
		productoDto.setPrecio(producto.getPrecio());
		return productoDto;
	}
	
	public static Producto convertirAProducto(ProductoDTO productoDto) {
		Producto producto = new Producto();
		producto.setId(productoDto.getId());
		producto.setNombre(productoDto.getNombre());
		producto.setStock(productoDto.getStock());
		producto.setPrecio(productoDto.getPrecio());
		return producto;
	}
}
