package br.com.consultamedica.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGerenciarConexao {
	/**
	 * Este m�todo abre uma conex�o com o banco de dados
	 * 
	 * @throws SQLException
	 *             caso haja um problema durante a abertura da conex�o
	 */
	public void abrirConexao() throws SQLException;

	/**
	 * Este m�todo retorna uma conex�o com o banco de dados
	 * 
	 * @return conex�o com o banco de dados
	 */
	public Connection getConexao() throws SQLException;

	/**
	 * Este m�todo fecha uma conex�o com o banco de dados
	 * 
	 * @param conexao
	 *            conex�o a ser fechada
	 * @throws SQLException
	 *             caso haja um problema durante o close da conex�o
	 */
	default void fecharConexao(Connection conexao) throws SQLException {

		if ((conexao != null) && (!conexao.isClosed()))
			conexao.close();
	}
}


