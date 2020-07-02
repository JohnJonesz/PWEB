package br.fatec.exercicio16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conecta {

	public static void main(String[] args) {
		Connection conexao = null;
		try {
			// registrando a classe JDBC e os prametros de conexao em tempo de
			// execucao
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			String url = "jdbc:derby://localhost:1527/agenda;create=true;update=true';";
			
			String usuario = "app";
			String senha = "app";
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado");
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
