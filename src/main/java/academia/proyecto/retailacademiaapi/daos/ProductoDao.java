package academia.proyecto.retailacademiaapi.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import academia.proyecto.retailacademiaapi.entities.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer> {

}
