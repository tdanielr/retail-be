package academia.proyecto.retailacademiaapi.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private Set<Producto> productos = new HashSet<Producto>();

	public int getId() {
		return id;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

}
