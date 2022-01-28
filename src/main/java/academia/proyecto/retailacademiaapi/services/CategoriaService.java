package academia.proyecto.retailacademiaapi.services;

import academia.proyecto.retailacademiaapi.dto.CategoriaDTO;
import academia.proyecto.retailacademiaapi.dto.RespuestaPaginaCategoria;

public interface CategoriaService {

	public CategoriaDTO crearCategoria(CategoriaDTO categoria);
	
	public RespuestaPaginaCategoria getAllCategorias(int numeroPagina, int tamañoPagina);
	
	public CategoriaDTO getCategoriaById(int id);
	
	public CategoriaDTO updateCategoria(CategoriaDTO categoriaDto, int id);
	
	public void deleteCategoria(int id);
	
}
