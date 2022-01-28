package academia.proyecto.retailacademiaapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "precio")
	private double precio;

	@Column(name = "stock")
	private int stock;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proveedor_id", nullable = false)
	private Proveedor proveedor;

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String nombre, double precio, int stock, Categoria categoria, Proveedor proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

}
