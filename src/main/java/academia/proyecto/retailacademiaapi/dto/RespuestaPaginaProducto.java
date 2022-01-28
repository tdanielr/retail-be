package academia.proyecto.retailacademiaapi.dto;

import java.util.List;

public class RespuestaPaginaProducto {

	private List<ProductoDTO> contenido;
	private int numeroPagina;
	private int medidaPagina;
	private int total;
	private int cantidadPaginas;
	private boolean ultima;

	// getters y setters
	public List<ProductoDTO> getContenido() {
		return contenido;
	}

	public void setContenido(List<ProductoDTO> contenido) {
		this.contenido = contenido;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getMedidaPagina() {
		return medidaPagina;
	}

	public void setMedidaPagina(int medidaPagina) {
		this.medidaPagina = medidaPagina;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public boolean isUltima() {
		return ultima;
	}

	public void setUltima(boolean ultima) {
		this.ultima = ultima;
	}

	public RespuestaPaginaProducto(List<ProductoDTO> contenido, int numeroPagina, int medidaPagina, int total,
			int cantidadPaginas, boolean ultima) {
		super();
		this.contenido = contenido;
		this.numeroPagina = numeroPagina;
		this.medidaPagina = medidaPagina;
		this.total = total;
		this.cantidadPaginas = cantidadPaginas;
		this.ultima = ultima;
	}

	public RespuestaPaginaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
