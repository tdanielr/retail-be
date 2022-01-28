package academia.proyecto.retailacademiaapi.dto;

import java.util.List;

public class RespuestaPaginaCategoria {

	private List<CategoriaDTO> contenido;
	private int numeroPagina;
	private int medidaPagina;
	private int total;
	private int cantidadPaginas;
	private boolean ultima;

	
	//getters y setters
	public List<CategoriaDTO> getContenido() {
		return contenido;
	}

	public void setContenido(List<CategoriaDTO> contenido) {
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

	public RespuestaPaginaCategoria() {
		super();
	}

	public RespuestaPaginaCategoria(List<CategoriaDTO> contenido, int numeroPagina, int medidaPagina, int total,
			int cantidadPaginas, boolean ultima) {
		super();
		this.contenido = contenido;
		this.numeroPagina = numeroPagina;
		this.medidaPagina = medidaPagina;
		this.total = total;
		this.cantidadPaginas = cantidadPaginas;
		this.ultima = ultima;
	}

}
