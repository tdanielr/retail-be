package academia.proyecto.retailacademiaapi.mapeos;

import academia.proyecto.retailacademiaapi.dto.CategoriaDTO;
import academia.proyecto.retailacademiaapi.entities.Categoria;

public class MapeoCategoria {

	// convierte una entidad a dto
	public static CategoriaDTO convertirADto(Categoria categoria) {

		CategoriaDTO categoriaDTO = new CategoriaDTO();

		categoriaDTO.setId(categoria.getId());
		categoriaDTO.setDescripcion(categoria.getDescripcion());
		return categoriaDTO;

	}

	// convierte un dto a una entidad
	public static Categoria convertirACategoria(CategoriaDTO categoriaDto) {

		Categoria categoria = new Categoria();
		categoria.setId(categoriaDto.getId());
		categoria.setDescripcion(categoriaDto.getDescripcion());
		return categoria;

	}

}
