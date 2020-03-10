package br.com.zup.estrelas.cidades.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Construa sua f�brica de conex�es e estabele�a conex�o com o banco de dados estrelas, teste
essa conex�o utilizando um programa principal. */

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/estrelas?user=root"
					+ "&password=root&useTimezone=true&serverTimezone=UTC");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
