package com.aula114.model;

public class Frases {

	private String frase;
	private Autor autor;
	private String categoria;

	
	
	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		// System.out.println(frase);
		this.frase = frase;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		System.out.println("El pojo: " + categoria);
		return categoria;
	}

	public void setCategoria(String categoria) {
		// System.out.println(categoria);
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return frase + ", \nAutor: " + autor + ", \nCategoria=" + categoria;
	}

}
