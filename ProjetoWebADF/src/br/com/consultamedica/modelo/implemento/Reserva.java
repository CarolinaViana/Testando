package br.com.consultamedica.modelo.implemento;

import java.util.Date;

public class Reserva {
	public static final String NM_ENTIDADE = "br.com.consultamedica.modelo.implemento.Reserva";
	public static final String NM_ATR_ID = "id";
	public static final String NM_ATR_DATA = "data";
	public static final String NM_ATR_ESPECIALIDADE = "especialidade";
	public static final String NM_ATR_HOSPITALBAIRRO = "hospitalbairro";
	private int id;
	private Date data;
	private String especialidade;
	private String hospitalbairro;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public void setData(String string) {

	}

	public void setHora(String string) {

	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getHospitalbairro() {
		return hospitalbairro;
	}

	public void setHospitalbairro(String hospitalbairro) {
		this.hospitalbairro = hospitalbairro;
	}

}
