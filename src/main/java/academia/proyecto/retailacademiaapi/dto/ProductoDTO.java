package academia.proyecto.retailacademiaapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProductoDTO {

	private int id;
	
	@NotEmpty(message = "el nombre no puede ser vacio")
	private String nombre;
	
	@Min(value = 1, message = "el stock no puede ser cero")
	private int stock;
	
	@Min(value = 1, message = "el stock no puede ser cero")
	private double precio;
	
	private int proveedorId;
	
	private int categoriaId;

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(int proveedorId) {
		this.proveedorId = proveedorId;
	}

	public int getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

}
