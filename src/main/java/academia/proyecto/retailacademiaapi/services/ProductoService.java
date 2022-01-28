package academia.proyecto.retailacademiaapi.services;

import academia.proyecto.retailacademiaapi.dto.ProductoDTO;
import academia.proyecto.retailacademiaapi.dto.RespuestaPaginaProducto;

public interface ProductoService {

	public ProductoDTO crearProducto(int categoriaId, int proveedorId, ProductoDTO productoDTO);
	
	public RespuestaPaginaProducto getAllProductos(int numeroPagina, int tamañoPagina);
	
	public ProductoDTO getProductoById(int id);
	
	public void deleteProducto(int id);
	
	public ProductoDTO updateProducto(ProductoDTO productoDto, int id);
	
}
