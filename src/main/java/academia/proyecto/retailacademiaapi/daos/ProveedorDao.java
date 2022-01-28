package academia.proyecto.retailacademiaapi.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import academia.proyecto.retailacademiaapi.entities.Proveedor;

public interface ProveedorDao extends JpaRepository<Proveedor, Integer> {

}
