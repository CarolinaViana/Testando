package br.com.consultamedica.dao.implemento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.consultamedica.dao.IReservaDAO;
import br.com.consultamedica.jdbc.IGerenciarConexao;
import br.com.consultamedica.jdbc.implemento.GerenciarConexao;
import br.com.consultamedica.modelo.implemento.Reserva;

public class ReservaDAO implements IReservaDAO {

	private static IReservaDAO iReservaDAO;
	private IGerenciarConexao iGerenciadorConexao;

	private ReservaDAO() {
		iGerenciadorConexao = GerenciarConexao.getInstancia();
		
		
	}

	public static IReservaDAO getInstancia() {
		if (iReservaDAO== null) {
			synchronized (IReservaDAO.class) {
				if (iReservaDAO == null) {
					iReservaDAO = new ReservaDAO();
				}
			}
		}
		return iReservaDAO;
	}

	@Override
	public void inserir(Reserva reserva) {

		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String sqlInsert;

		sqlInsert = "INSERT INTO RESERVA (RES_DATA, RES_ESPECIALIDADE, RES_HOSPITALBAIRRO ) VALUES (?,?,?)";

		try {

			this.iGerenciadorConexao.abrirConexao();

			preparedStatement = this.iGerenciadorConexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			
			
			//Formato data
			preparedStatement.setDate(1,new java.sql.Date(reserva.getData().getTime()));
			preparedStatement.setString(2,reserva.getEspecialidade());
			preparedStatement.setString(3, reserva.getHospitalbairro());

			

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();

			resultSet.next();

			reserva.setId((int) resultSet.getLong(PreparedStatement.RETURN_GENERATED_KEYS));

			this.iGerenciadorConexao.getConexao().commit();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void alterar(Reserva reserva) {

	}

	@Override
	public void excluir(Reserva reserva) {

	}

	@Override
	public Reserva consultar(Reserva reserva) {
		return null;
	}

	@Override
	public List<Reserva> listar() {
		return null;
	}
}
