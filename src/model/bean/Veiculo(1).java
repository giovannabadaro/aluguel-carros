/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Cida
 */
public class Veiculo {
    private String Placa;
    private String Chassi;
    private String Cor;
    private String Km;  
    private String DatamedidaKm;
    private String UltimaRevisao;
    private String Filial_idFilial;
    private String Modelo_codigo;

    public Veiculo() {
    	
    }
    
    public Veiculo(String placa, String chassi, String cor, String km, String datamedidaKm, String ultimaRevisao,
			String filial_idFilial, String modelo_codigo) {
		super();
		Placa = placa;
		Chassi = chassi;
		Cor = cor;
		Km = km;
		DatamedidaKm = datamedidaKm;
		UltimaRevisao = ultimaRevisao;
		Filial_idFilial = filial_idFilial;
		Modelo_codigo = modelo_codigo;
	}

	public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getChassi() {
        return Chassi;
    }

    public void setChassi(String Chassi) {
        this.Chassi = Chassi;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public String getDatamedidaKm() {
        return DatamedidaKm;
    }

    public void setDatamedidaKm(String DatamedidaKm) {
        this.DatamedidaKm = DatamedidaKm;
    }

    public String getUltimaRevisao() {
        return UltimaRevisao;
    }

    public void setUltimaRevisao(String UltimaRevisao) {
        this.UltimaRevisao = UltimaRevisao;
    }

    public String getFilial_idFilial() {
        return Filial_idFilial;
    }

    public void setFilial_idFilial(String Filial_idFilial) {
        this.Filial_idFilial = Filial_idFilial;
    }

    public String getModelo_codigo() {
        return Modelo_codigo;
    }

    public void setModelo_codigo(String Modelo_codigo) {
        this.Modelo_codigo = Modelo_codigo;
    }
      public String getKm() {
        return Km;
    }

    public void setKm(String Km) {
        this.Km = Km;
    }
    
    
}
