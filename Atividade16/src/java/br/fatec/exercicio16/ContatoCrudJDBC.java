package br.fatec.exercicio6;

import java.util.*;
import java.sql.*;
import java.sql.Date;


public class ContatoCrudJDBC {

	public void salvar(Contato contato) {
		Connection conexao = this.geraConexao();
		PreparedStatement ps = null;

		String sql = "insert into contato (nome, telefone, email, dt_cad, obs) values (?, ?, ?, ?, ?)";

		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getTelefone());
			ps.setString(3, contato.getEmail());
			ps.setDate(4, contato.getDataCadastro());
			ps.setString(5, contato.getObservacao());
			ps.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	public void atualizar(Contato contato) {
		Connection conexao = this.geraConexao();
		PreparedStatement ps = null;

		String sql = "update from contato (nome, telefone, email, dt_cad, obs) values (?, ?, ?, ?, ?) where codigo=?";

		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getTelefone());
			ps.setString(3, contato.getEmail());
			ps.setDate(4, contato.getDataCadastro());
			ps.setString(5, contato.getObservacao());
			ps.setInt(6, contato.getCodigo());
			ps.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	public void excluir(Contato contato) {
		Connection conexao = this.geraConexao();
		PreparedStatement ps = null;

		String sql = "delete from contato where codigo=?";

		try {
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, contato.getCodigo());
			ps.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro:" + e.getMessage());
		}

	}
	public List<Contato> listar() {
		Connection conexao = this.geraConexao();
		List<Contato> contatos = new ArrayList<Contato>();
		Statement consulta = null;
		ResultSet resultado = null;
		Contato contato = null;
		String sql = "select * from contato";
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				contato = new Contato();
				contato.setCodigo(resultado.getInt("codigo"));
				contato.setNome(resultado.getString("nome"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setEmail(resultado.getString("email"));
				contato.setDataCadastro(resultado.getDate("dt_cad"));
				contato.setObservacao(resultado.getString("obs"));
				contatos.add(contato);
			}
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar contato " + e.getMessage());

		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return contatos;
	}

	public Contato buscaContato(int valor) {
		Connection conexao = this.geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Contato contato = null;
		String sql = "select * from contato  where codigo=?";
		try {
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, valor);
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				contato = new Contato();
				contato.setCodigo(resultado.getInt("codigo"));
				contato.setNome(resultado.getString("nome"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setEmail(resultado.getString("email"));
				contato.setDataCadastro(resultado.getDate("codigo"));
				contato.setObservacao(resultado.getString("codigo"));
			}
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Erro ao listar contato " + e.getMessage());

		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação consulta " + e.getMessage());
			}
		}
		return contato;
	}

	public Connection geraConexao() {
		Connection conexao = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			String url = "jdbc:derby://localhost:1527/agenda;create=true;update=true';";

			String usuario = "app";
			String senha = "app";
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou");
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return conexao;
	}

	public static void main(String[] args) {
		ContatoCrudJDBC contatoCRUDJDBC = new ContatoCrudJDBC();

		Contato bar1ze = new Contato();
		bar1ze.setNome("bar1ze");
		bar1ze.setTelefone("1515");
		bar1ze.setEmail("bar1ze@gmail.com");
		bar1ze.setDataCadastro(new Date(System.currentTimeMillis()));
		bar1ze.setObservacao("novo contato");
		contatoCRUDJDBC.salvar(bar1ze);

		Contato bar2ze = new Contato();
		bar2ze.setNome("bar2ze");
		bar2ze.setTelefone("1919");
		bar2ze.setEmail("bar2ze@gmail.com");
		bar2ze.setDataCadastro(new Date(System.currentTimeMillis()));
		bar2ze.setObservacao("outro novo contato");
		contatoCRUDJDBC.salvar(bar2ze);

		System.out.println("Contatos cadastrados " + contatoCRUDJDBC.listar().size());
	}
}