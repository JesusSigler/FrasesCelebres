package com.aula114.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.aula114.model.Frases;

@ManagedBean
@ViewScoped
public class ViewManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Frases f = new Frases();
	private Set<String> listaCategorias;
	private String categoria;
	private ViewMysql v = new ViewMysql();
	private List<Frases> listaF;

	public ViewManager() {
		listaCategorias = v.listaCategorias();
	}

	public List<Frases> getListaF() {
		return listaF;
	}

	public void setListaF(List<Frases> listaF) {
		this.listaF = listaF;
	}

	public Set<String> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(Set<String> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
		listaF = v.listaFrases(categoria);
	}

	
	public Frases getF() {
		return f;
	}

	public void setF(Frases f) {
		this.f = f;
	}

	public ViewMysql getV() {
		return v;
	}

	public void setV(ViewMysql v) {
		this.v = v;
	}

	public String listar() {
		listaF = v.listaFrases(categoria);
		return null;
	}

}
