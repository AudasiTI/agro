package br.com.audasi.agro.entity;

public class Status {

	private Boolean sucesso;

	public Status(Boolean resultado) {
		sucesso = resultado;
	}

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

}
