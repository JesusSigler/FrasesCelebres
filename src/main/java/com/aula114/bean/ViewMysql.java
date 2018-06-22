package com.aula114.bean;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.aula114.model.Autor;
import com.aula114.model.Frases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class ViewMysql {
	private Frases f = new Frases();
	private Autor a = new Autor();
	private Connection conn;
	private PreparedStatement stmt;
	private Set<String> cat;
	private List<Frases>listaF;

		
	private void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/frases_celebres?useSSL=false", "root",
					"root114");

		} catch (ClassNotFoundException e) {
			System.out.println("No se puede conectar");
		} catch (SQLException e) {
			System.out.println("No se ha importado el driver");
		}
	}

	private void desconectar() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Frases> listaFrases(String categoria) {
		listaF = new ArrayList<>();
		
		String sql = "select f.frase, a.nombre_completo, a.fecha_nac from frases f, autores a where categoria = '"
				+ categoria + "' and a.id_autor = f.id_autor";

		try {
			conectar();
			stmt = conn.prepareStatement(sql);
			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				f = new Frases();
				a = new Autor();
				a.setNombre_completo(rset.getString("nombre_completo"));
				a.setFecha_nac(rset.getDate("fecha_nac"));
				f.setAutor(a);
				f.setFrase(rset.getString("frase"));
				listaF.add(f);
			}
			rset.close();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			desconectar();
		}
		return listaF;
	}

	public Set<String> listaCategorias() {
		cat = new HashSet<String>();

		String sql = "select categoria from frases";
		try {
			cat.add("<Categorías>");
			conectar();
			stmt = conn.prepareStatement(sql);
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
				cat.add(rset.getString("categoria"));
			}
			rset.close();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			desconectar();
		}
		return cat;
	}

	public Set<String> getCat() {
		return cat;
	}

	public void setCat(Set<String> cat) {
		this.cat = cat;
	}
	

}
