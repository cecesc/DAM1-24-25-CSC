package ud6.practicas.biblioteca;

import java.io.Serializable;

public class Libro implements Serializable {
	private String titulo, autor, editorial, refBibliografica;
	private int codigo,añoPublicacion, stock;
	
	public Libro(int codigo, String titulo, String autor, String editorial, String refBibliografica,
			int añoPublicacion, int stock) {
		
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.refBibliografica = refBibliografica;
		this.añoPublicacion = añoPublicacion;
		this.stock = stock;
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getRefBibliografica() {
		return refBibliografica;
	}

	public void setRefBibliografica(String refBibliografica) {
		this.refBibliografica = refBibliografica;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", refBibliografica="
				+ refBibliografica + ", codigo=" + codigo + ", añoPublicacion=" + añoPublicacion + "]";
	}
	
	



}