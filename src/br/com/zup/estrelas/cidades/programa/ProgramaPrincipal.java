package br.com.zup.estrelas.cidades.programa;
import java.sql.SQLException;

import br.com.zup.estrelas.cidades.dao.CidadeDao;

public class ProgramaPrincipal {

	public static void main(String[] args) throws SQLException {

		CidadeDao cidadeDao = new CidadeDao();
		cidadeDao.insereCidade();
		
		System.out.println("Conectado!");
		
		/* int opcao;
		do {
			System.out.println(" Escolha uma das seguintes opções: ");
			System.out.println(" Digite 1 para cadastrar uma cidade. ");
	}*/
		
		} 

	}




