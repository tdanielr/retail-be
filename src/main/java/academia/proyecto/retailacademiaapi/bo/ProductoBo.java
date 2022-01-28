package academia.proyecto.retailacademiaapi.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import academia.proyecto.retailacademiaapi.daos.CategoriaDao;
import academia.proyecto.retailacademiaapi.daos.ProductoDao;
import academia.proyecto.retailacademiaapi.daos.ProveedorDao;
import academia.proyecto.retailacademiaapi.dto.ProductoDTO;
import academia.proyecto.retailacademiaapi.dto.RespuestaPaginaProducto;
import academia.proyecto.retailacademiaapi.entities.Categoria;
import academia.proyecto.retailacademiaapi.entities.Producto;
import academia.proyecto.retailacademiaapi.entities.Proveedor;
import academia.proyecto.retailacademiaapi.excepciones.RecursoNotFoundExcepcion;
import academia.proyecto.retailacademiaapi.mapeos.MapeoProducto;
import academia.proyecto.retailacademiaapi.services.ProductoService;

@Service
public class ProductoBo implements ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Autowired
	private CategoriaDao categoriaDao;

	@Autowired
	private ProveedorDao proveedorDao;

	@Override
	public ProductoDTO crearProducto(int categoriaId, int proveedorId, ProductoDTO productoDTO) {

		// mapeo el dto a entidad para persistir
		Producto producto = MapeoProducto.convertirAProducto(productoDTO);

		// busco la categoria
		Categoria categoria = categoriaDao.findById(categoriaId)
				.orElseThrow(() -> new RecursoNotFoundExcepcion("Categoria", "id"));

		// busco el proveedor
		Proveedor proveedor = proveedorDao.findById(proveedorId)
				.orElseThrow(() -> new RecursoNotFoundExcepcion("Proveedor", "id"));

		producto.setCategoria(categoria);
		producto.setProveedor(proveedor);
		Producto productoNuevo = productoDao.save(producto);

		ProductoDTO productoNuevoDto = MapeoProducto.convertirADto(productoNuevo);
		productoNuevoDto.setCategoriaId(productoNuevo.getCategoria().getId());
		productoNuevoDto.setProveedorId(productoNuevo.getProveedor().getId());

		return productoNuevoDto;
	}

	@Override
	public RespuestaPaginaProducto getAllProductos(int numeroPagina, int tamañoPagina) {

		Pageable pageable = PageRequest.of(numeroPagina, tamañoPagina);
		Page<Producto> productos = productoDao.findAll(pageable);

		List<Producto> listaProducto = productos.getContent();

		List<ProductoDTO> listaProductoDto = new ArrayList<ProductoDTO>();

		for (Producto prod : listaProducto) {
			ProductoDTO prodDTO = MapeoProducto.convertirADto(prod);
			prodDTO.setCategoriaId(prod.getCategoria().getId());
			prodDTO.setProveedorId(prod.getProveedor().getId());
			listaProductoDto.add(prodDTO);
		}

		RespuestaPaginaProducto respuesta = new RespuestaPaginaProducto();
		respuesta.setContenido(listaProductoDto);
		respuesta.setNumeroPagina(productos.getNumber());
		respuesta.setMedidaPagina(productos.getSize());
		respuesta.setTotal((int) productos.getTotalElements());
		respuesta.setCantidadPaginas(productos.getTotalPages());
		respuesta.setUltima(productos.isLast());

		return respuesta;
	}

	@Override
	public ProductoDTO getProductoById(int id) {
		Producto producto = productoDao.findById(id).orElseThrow(() -> new RecursoNotFoundExcepcion("Producto", "id"));

		ProductoDTO productoDto = MapeoProducto.convertirADto(producto);

		productoDto.setCategoriaId(producto.getCategoria().getId());
		productoDto.setProveedorId(producto.getProveedor().getId());
		return productoDto;

	}

	@Override
	public void deleteProducto(int id) {

		// busco la categoria
		Producto producto = productoDao.findById(id).orElseThrow(() -> new RecursoNotFoundExcepcion("Producto", "id"));

		// elimino la categoria
		productoDao.delete(producto);

	}

	@Override
	public ProductoDTO updateProducto(ProductoDTO productoDto, int id) {

		// encuentro el producto a actualizar
		Producto producto = productoDao.findById(id).orElseThrow(() -> new RecursoNotFoundExcepcion("Producto", "id"));

		// seteo el producto encontrado con los datos nuevos
		producto.setNombre(productoDto.getNombre());
		producto.setPrecio(productoDto.getPrecio());
		producto.setStock(productoDto.getStock());

		// busco la categoria y el proveedor
		Categoria categoria = categoriaDao.findById(productoDto.getCategoriaId())
				.orElseThrow(() -> new RecursoNotFoundExcepcion("Categoria", "id"));

		Proveedor proveedor = proveedorDao.findById(productoDto.getProveedorId())
				.orElseThrow(() -> new RecursoNotFoundExcepcion("Proveedor", "id"));
		
		producto.setCategoria(categoria);
		producto.setProveedor(proveedor);
		
		// guardo el producto
		Producto productoNuevo = productoDao.save(producto);

		// devuelvo el dto
		ProductoDTO productoDtoNuevo = MapeoProducto.convertirADto(productoNuevo);

		productoDtoNuevo.setCategoriaId(productoNuevo.getCategoria().getId());
		productoDtoNuevo.setProveedorId(productoNuevo.getProveedor().getId());
		return productoDtoNuevo;
	}

}
