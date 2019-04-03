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
public class Reserva {

    private String idReserva;
    private String dataRetirada;
    private String dataDevolucao;
    private String Filial_idFilial1;
    private String Filial_idFilial;
    private String Cliente_idCliente;
    private String ModeloCodigo;
    private String Custo;

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getFilial_idFilial1() {
        return Filial_idFilial1;
    }

    public void setFilial_idFilial1(String Filial_idFilial1) {
        this.Filial_idFilial1 = Filial_idFilial1;
    }

    public String getFilial_idFilial() {
        return Filial_idFilial;
    }

    public void setFilial_idFilial(String Filial_idFilial) {
        this.Filial_idFilial = Filial_idFilial;
    }

    public String getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setCliente_idCliente(String Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }

    public String getModeloCodigo() {
        return ModeloCodigo;
    }

    public void setModeloCodigo(String ModeloCodigo) {
        this.ModeloCodigo = ModeloCodigo;
    }

    public String getCusto() {
        return Custo;
    }

    public void setCusto(String Custo) {
        this.Custo = Custo;
    }
    
    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }
    
    
    
}
