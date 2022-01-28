package academia.proyecto.retailacademiaapi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String dirrecion;
	
	@Column(name="cuit")
	private String cuit;

	@OneToMany(mappedBy = "proveedor")
	private List<Producto> productos;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirrecion() {
		return dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public Proveedor(int id, String nombre, String dirrecion, String cuit) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dirrecion = dirrecion;
		this.cuit = cuit;
	}

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
