package academia.proyecto.retailacademiaapi.bo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import academia.proyecto.retailacademiaapi.daos.CategoriaDao;
import academia.proyecto.retailacademiaapi.dto.CategoriaDTO;
import academia.proyecto.retailacademiaapi.dto.RespuestaPaginaCategoria;
import academia.proyecto.retailacademiaapi.entities.Categoria;
import academia.proyecto.retailacademiaapi.excepciones.RecursoNotFoundExcepcion;
import academia.proyecto.retailacademiaapi.mapeos.MapeoCategoria;
import academia.proyecto.retailacademiaapi.services.CategoriaService;

@Service
public class CategoriaBo implements CategoriaService {

	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public CategoriaDTO crearCategoria(CategoriaDTO categoriaDto) {
		// pasamos el dto al dao
		Categoria categoria = MapeoCategoria.convertirACategoria(categoriaDto);

		// llamo al dao para insertar la categoria
		Categoria nuevaCategoria = categoriaDao.save(categoria);

		// convertimos el resultado al dto
		CategoriaDTO categoriaNuevaDto = MapeoCategoria.convertirADto(nuevaCategoria);
		return categoriaNuevaDto;

	}

	@Override
	public RespuestaPaginaCategoria getAllCategorias(int numeroPagina, int tamañoPagina) {

		Pageable pageable = PageRequest.of(numeroPagina, tamañoPagina);
		Page<Categoria> categorias = categoriaDao.findAll(pageable);
		
		
		// obtengo la lista de categorias de la bd
		List<Categoria> listaCategoria = categorias.getContent();

		// mapeo la lista de categorias a categoriasDto
		List<CategoriaDTO> listaCategoriaDto = listaCategoria.stream().map(cat -> MapeoCategoria.convertirADto(cat))
				.collect(Collectors.toList());

		RespuestaPaginaCategoria respuesta = new RespuestaPaginaCategoria();
		respuesta.setContenido(listaCategoriaDto);
		respuesta.setNumeroPagina(categorias.getNumber());
		respuesta.setMedidaPagina(categorias.getSize());
		respuesta.setTotal((int) categorias.getTotalElements());
		respuesta.setCantidadPaginas(categorias.getTotalPages());
		respuesta.setUltima(categorias.isLast());
		
		return respuesta;

	}

	@Override
	public CategoriaDTO getCategoriaById(int id) {
		Categoria categoria = categoriaDao.findById(id)
				.orElseThrow(() -> new RecursoNotFoundExcepcion("Categoria", "id"));

		CategoriaDTO categoriaDto = MapeoCategoria.convertirADto(categoria);

		return categoriaDto;

	}

	@Override
	public CategoriaDTO updateCategoria(CategoriaDTO categoriaDto, int id) {
		
		//encuentro la categoria a actualizar
		Categoria categoria = categoriaDao.findById(id).orElseThrow(() -> new RecursoNotFoundExcepcion("Categoria", "id"));
		
		//seteo la categoria encontrada con los datos nuevos 
		categoria.setDescripcion(categoriaDto.getDescripcion());
		
		//guardo la categoria
		Categoria categoriaNueva = categoriaDao.save(categoria);
		
		//devuelvo el dto
		CategoriaDTO categoriaDtoNueva = MapeoCategoria.convertirADto(categoriaNueva);
		
		return categoriaDtoNueva;
	}

	@Override
	public void deleteCategoria(int id) {
		
		//busco la categoria
		Categoria categoria = categoriaDao.findById(id).orElseThrow(() -> new RecursoNotFoundExcepcion("Categoria", "id"));
		
		//elimino la categoria
		categoriaDao.delete(categoria);
		
	}

}
