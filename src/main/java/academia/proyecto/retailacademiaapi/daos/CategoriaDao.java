package academia.proyecto.retailacademiaapi.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import academia.proyecto.retailacademiaapi.entities.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Integer> {

	
	
}
