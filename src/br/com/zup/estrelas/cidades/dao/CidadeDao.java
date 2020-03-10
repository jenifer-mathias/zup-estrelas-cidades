package br.com.zup.estrelas.cidades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.zup.estrelas.cidades.factory.ConnectionFactory;
import br.com.zup.estrelas.cidades.pojo.Cidade;

public class CidadeDao {

	private static final int TEXTO_DIGITADO = 1;
	private static final int CEP_REMOVE = 1;
	private static final int DATA_FUNDACAO = 7;
	private static final int RENDA_PER_CAPITA = 6;
	private static final int ESTADO = 5;
	private static final int CAPITAL = 4;
	private static final int NRO_HABITANTES = 3;
	private static final int NOME = 2;
	private static final int CEP = 1;
	private Connection conn;

	public CidadeDao() {

		this.conn = new ConnectionFactory().getConnection();
	}

	public boolean insereCidade() throws SQLException {

		String sql = "insert into cidade"
				+ "(cep, nome, nro_habitantes, capital, estado, renda_per_capita, data_fundacao)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(CEP, 11524630);
			stmt.setString(NOME, "São Bernardo do Campo");
			stmt.setInt(NRO_HABITANTES, 500000);
			stmt.setBoolean(CAPITAL, false);
			stmt.setString(ESTADO, "sp");
			stmt.setDouble(RENDA_PER_CAPITA, 20000);
			stmt.setString(DATA_FUNDACAO, "1458-03-01");

			stmt.execute();
			stmt.close();
			return true;

		} catch (SQLException e) {
			System.out.println(" Dado não encontrado! ");

			return false;
		}
	}

	// Crie no seu CidadeDAO o método de listagem de cidades sem filtros.

	public List<Cidade> listaCidades() {

		List<Cidade> cidades = new ArrayList<>();

		String sql = "select * from cidade";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cidade cidade = new Cidade();

				cidade.setCep(rs.getInt("cep"));
				cidade.setNome(rs.getString("nome"));
				cidade.setNro_habitantes(rs.getInt("nro_habitantes"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setRenda_per_capta(rs.getDouble("renda_per_capita"));
				cidade.setData_fundacao(rs.getString("data_fundacao"));

				cidades.add(cidade);
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao listar cidades");
			System.out.println(e.getMessage());
		}

		return cidades;
	}

	// Adicione ao DAO a funcionalidade de remover uma cidade passando como
	// parâmetro seu número de cep.

	public boolean removeCidade(int cep) {

		String sql = "delete from cidade where cep = ?";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(CEP_REMOVE, cep);

			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao deletar cidade");
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	// Crie no seu DAO um método que é capaz de retornar uma cidade com base no seu número de cep.

	public Cidade retornaCidade(int cep) {

		String sql = "select * from cidade c where cidade = ?";

		Cidade cidade = new Cidade();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(CEP, cep);

			ResultSet rs = stmt.executeQuery();


			cidade.setCep(rs.getInt("cep"));
			cidade.setNome(rs.getString("nome"));
			cidade.setNro_habitantes(rs.getInt("nro_habitantes"));
			cidade.setCapital(rs.getBoolean("capital"));
			cidade.setEstado(rs.getString("estado"));
			cidade.setRenda_per_capta(rs.getDouble("renda_per_capita"));
			cidade.setData_fundacao(rs.getString("data_fundacao"));
			
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao mostrar cidade");
			System.out.println(e.getMessage());
		}	
		return cidade;
	}

	// Crie um método que é capaz de pesquisar cidades cujos nomes se iniciam por um
	// texto passado como parâmetro.

public List<Cidade> pesquisaCidade(String texto) {
	
	List<Cidade> cidades = new ArrayList<>();
	
		String sql = " select * from cidade c where c.nome like '?%' ";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(TEXTO_DIGITADO, texto);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cidade cidade = new Cidade();

				cidade.setCep(rs.getInt("cep"));
				cidade.setNome(rs.getString("nome"));
				cidade.setNro_habitantes(rs.getInt("nro_habitantes"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setRenda_per_capta(rs.getDouble("renda_per_capita"));
				cidade.setData_fundacao(rs.getString("data_fundacao"));
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar cidades");
			System.out.println(e.getMessage());
		}
		return cidades;

	}

// Crie um método que é capaz de listar cidades filtradas pela sigla de estado.

public List<Cidade> pesquisaPorSigla(String estado) {
	
	List<Cidade> cidades = new ArrayList<>();
	
		String sql = " select * from cidade c where c.estado = '?' ";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(ESTADO, estado);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cidade cidade = new Cidade();

				cidade.setCep(rs.getInt("cep"));
				cidade.setNome(rs.getString("nome"));
				cidade.setNro_habitantes(rs.getInt("nro_habitantes"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setRenda_per_capta(rs.getDouble("renda_per_capita"));
				cidade.setData_fundacao(rs.getString("data_fundacao"));
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar cidades");
			System.out.println(e.getMessage());
		}
		return cidades;

	}

// PAREI NA 5!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1

 // Crie um método que recebe a sigla de um estado e retorna a quantidade de cidades daquele estado.

public List<Cidade> retornaQtdCidades(String estado) {
	
	List<Cidade> cidades = new ArrayList<>();
	
		String sql = " select * from cidade c where c.estado = '?' ";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(ESTADO, estado);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cidade cidade = new Cidade();

				cidade.setCep(rs.getInt("cep"));
				cidade.setNome(rs.getString("nome"));
				cidade.setNro_habitantes(rs.getInt("nro_habitantes"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setRenda_per_capta(rs.getDouble("renda_per_capita"));
				cidade.setData_fundacao(rs.getString("data_fundacao"));
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar cidades");
			System.out.println(e.getMessage());
		}
		return cidades;

	}

}
