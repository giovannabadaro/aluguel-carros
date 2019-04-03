package model.bean;

public class GeradorDeIds {
	private int idCliente = 1;
	private int idFilial = 1;
	private int idModelo = 1;
	
	public int GeraNovoIdCliente() {
		idCliente ++;
			return idCliente-1;
	}
	
	public int RecuperaUtimoIdCliente() {
		return idCliente-1;
	}
	
	public int GeraNovoIdFilial() {
		idFilial ++;
			return idFilial-1;
	}
	
	public int RecuperaUtimoIdFilial() {
		return idFilial-1;
	}
	
	
	public int GeraNovoIdModelo() {
		idModelo ++;
			return idModelo-1;
	}
	
	public int RecuperaUtimoIdModelo() {
		return idModelo-1;
	}
}
