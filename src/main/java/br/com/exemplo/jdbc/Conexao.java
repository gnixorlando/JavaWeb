package br.com.exemplo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
public static Connection getConnection () {
		
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
			System.out.println("Conectado!");
		} catch (SQLException e) {
			System.out.println("Erro - conexão com banco" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro - drive" + e.getMessage());
		} return con;
		
		
	}
}
